/*練習1.7:iが逆順に値が減るようにImprovedFibonacciのループを書き直しなさい*/

package jpl.ch01.ex07;

public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;
	/**
	 * 偶数要素に'*'をつけて、フィボナッチ数列の最初の方の要素を表示する
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lo = 1;
		int hi = 1;
		String mark;
		
		System.out.println(MAX_INDEX+": "+lo);
		for(int i = MAX_INDEX-1 ; i >= 1 ; i--) {
			if(hi % 2 == 0) mark = " *";
			else mark = "";
			
			System.out.println(i + ": "+ hi + mark);
			hi = lo + hi;
			lo = hi - lo;
		}
		
	}

}
