/*練習1.13:printlnではなく、printfを使用して、
 * ImprovedFibonacciを書き直しなさい*/

package jpl.ch01.ex13;

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
		
		System.out.printf("1 : %2d%n",lo);
		//配列に格納
		for(int i = 2 ; i <= MAX_INDEX ; i++) {
			System.out.printf("%d : %2d",i,hi);
			if(hi%2==0) System.out.printf(" *");
			System.out.printf("%n");
			hi = lo + hi;
			lo = hi - lo;
		}		
	}


}
