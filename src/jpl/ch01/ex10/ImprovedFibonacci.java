/*ImprovedFibonacciアプリケーションを修正して、数列を配列に保存されるようにしなさい
 * その際に、数列の値とその値が偶数かを示すブール値を保持するクラスを作成して
 * そのクラスのオブジェクトへの参照を配列として持つようにしなさい*/

package jpl.ch01.ex10;

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	/**
	 * 偶数要素に'*'をつけて、フィボナッチ数列の最初の方の要素を表示する
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lo = 1;
		int hi = 1;
		
		Term[] aryT = new Term[MAX_INDEX];
		aryT[0] = new Term(lo);
		
		//配列に格納
		for(int i = 1 ; i < MAX_INDEX ; i++) {
			aryT[i] = new Term(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
		
		//表示
		for(int i = 0; i< MAX_INDEX; i++){
			System.out.println((i+1) +" : "+ aryT[i].toString());
		}
		
	}


}
