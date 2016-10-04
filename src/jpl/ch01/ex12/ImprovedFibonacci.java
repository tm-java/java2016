/*練習1.12:ImprovedFibonacciを修正してprintlnで文字列を直接表示するのではなく
 * Stringオブジェクトを作成して配列に入れるようにしてみてください*/

package jpl.ch01.ex12;

import jpl.ch01.ex10.Term;

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	/**
	 * 偶数要素に'*'をつけて、フィボナッチ数列の最初の方の要素を表示する
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lo = 1;
		int hi = 1;
		
		String[] aryS = new String[MAX_INDEX];
		aryS[0] = "1 : " + (new Term(lo)).toString();
		
		//配列に格納
		for(int i = 1 ; i < MAX_INDEX ; i++) {
			aryS[i] = (i+1) + " : " + (new Term(hi)).toString();
			hi = lo + hi;
			lo = hi - lo;
		}
		
		//表示
		for(String s : aryS){
			System.out.println(s);
		}
		
	}

}
