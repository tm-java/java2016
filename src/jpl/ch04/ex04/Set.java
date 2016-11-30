package jpl.ch04.ex04;

import java.util.Iterator;

/**重複のないコレクション*/
public interface Set<E> extends Collection<E> {
	/**指定された要素がこのコレクションに格納されていることを保証します*/
	boolean add(E e);
	/**指定されたコレクションのすべての要素をこのコレクションに追加します（オプションの操作）*/
	boolean addALL(Collection<? extends E> c);
	/**このコレクションからすべての要素を削除します*/
	void clear();
	/**指定された要素がコレクションに含まれている場合にtrueを返します*/
	boolean contains(Object o);
	/**指定されたコレクションのすべての要素がこのコレクション内にある場合はtrueを返します*/
	boolean containsALL(Collection<?> c);
	/**指定されたオブジェクトとこのコレクションが等しいかどうかを比較します*/
	boolean equals(Object o);
	/**コレクションのハッシュコード値を返します*/
	int hashCode();
	/**このコレクションに要素がない場合にtrueを返します*/
	boolean isEmpty();
	/**コレクションの要素のイテレータを返します*/
	Iterator<E> iterator();
	/**指定された要素のインスタンスがこのコレクションにあれば、
	 * そのインスタンスをコレクションから１つ削除します*/
	boolean remove(Object o);
	/**指定されたコレクションにも格納されているこのコレクションのすべての要素を削除します*/
	boolean removeALL(Collection<?> c);
	/**このコレクション中の要素の数を返します*/
	int size();
	/**このコレクションの要素がすべて格納されている配列を返します*/
	Object[] toArray();
	/**このコレクションないのすべての要素を保持する配列を返します
	 * 返される配列の実行時の型は、指定された配列の型です*/
	<T> T[] toArray(T[] a); 


}
