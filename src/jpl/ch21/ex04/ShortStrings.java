package jpl.ch21.ex04;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ShortStrings implements ListIterator<String> {
	private ListIterator<String> strings;
	private String nextShort;
	private String preShort;
	private final int maxLen;
	private enum Operate {
		NOTYET, NEXT, PREVIOUS;
	}
	private Operate ope;
	
	public ShortStrings(ListIterator<String> strings, int maxLen) {
		this.strings = strings;
		this.maxLen = maxLen;
		this.nextShort = null;
		this.preShort = null;
		this.ope = Operate.NOTYET;
	}
	
	@Override
	public boolean hasNext() {
		if (nextShort != null) {
			return true;
		}
		
		while(strings.hasNext()) {
			nextShort = strings.next();
			if (nextShort.length() <= maxLen) {
				strings.previous();//一旦反復子を前に戻す
				return true;
			}
		}
		nextShort = null;
		return false;
	}

	@Override
	public String next() {
		if (nextShort == null && !hasNext()) {
			throw new NoSuchElementException();
		}
		ope = Operate.NEXT;
		nextShort = null;
		return strings.next();
	}

	@Override
	public boolean hasPrevious() {
		if (preShort != null) {
			return true;
		}
		
		while(strings.hasPrevious()) {
			preShort = strings.previous();
			if (preShort.length() <= maxLen) {
				strings.next();
				return true;
			}
		}
		preShort = null;
		return false;
	}

	@Override
	public String previous() {
		if (preShort == null && !hasPrevious()) {
			throw new NoSuchElementException();
		}
		ope = Operate.PREVIOUS;
		preShort = null;
		return strings.previous();
	}

	@Override
	public int nextIndex() {
		if (nextShort == null && !hasNext()) {
			while (strings.hasNext()) {
				strings.next();
			}
			//これ以上、リスト内のnextShortがない場合、リストを最後まで進める
		}
		return strings.nextIndex();
		//次にnextを呼び出した時に返されることになる要素のインデックスを返す。
		//リスト反復子がリストの末尾にある場合はリストのサイズを返す
	}

	@Override
	public int previousIndex() {
		if (preShort == null && !hasPrevious()) {
			while (strings.hasPrevious()) {
				strings.previous();
			}
		}
		return strings.previousIndex();
		//次にpreviousを呼び出した時に返されることになる要素のインデックスを返す。
	}

	@Override
	public void remove() {
		if (ope == Operate.NOTYET) {
			throw new IllegalStateException();
		}
		
		if (ope == Operate.NEXT) {
			this.previous();
		} else {
			this.next();
		}
		ope = Operate.NOTYET;
		strings.remove();
	}

	@Override
	public void set(String e) {
		if (e.length() > maxLen) {
			throw new IllegalArgumentException();
			//eが最大長より長い文字列は追加できない
			//もし、nextやpreviouseで見つけた短い文字列を、長い文字列に書き換えた場合、
			//このあとに呼ばれるかもしれないremoveに影響が出るため。
			//もしくは、UnsupportedOperationExceptionに変更する
		}
		if (ope == Operate.NOTYET) {
			throw new IllegalStateException();
		}
		
		if (ope == Operate.NEXT) {
			this.previous();
			strings.set(e);
			this.next();
		} else {
			this.next();
			strings.set(e);
			this.previous();
		}
	}

	@Override
	public void add(String e) {
		if (e.length() > maxLen) {
			throw new IllegalArgumentException();
			//eが最大長より長い文字列は追加できない
			//このフィルターを通して、今後決してreturnされることのない文字列を追加する必要がない
		}
		ope = Operate.NOTYET;
		strings.add(e);
	}	
}
