/*練習1.3:Fibonacciプログラムの出力リストにタイトルを追加しなさい*/

package jpl.ch01.ex03;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**値が50未満のフィボナッチ数列を表示する*/
		
		int lo = 1;
		int hi = 1;
		System.out.println("Fibonacci");
		System.out.println(lo);
		
		while(hi < 50){
			System.out.println(hi);
			hi = lo + hi;	//新しいhi
			lo = hi - lo;	/*新しいloは、（合計 - 古いlo）
			 					すなわち、古いhi*/
		}
		

	}

}
