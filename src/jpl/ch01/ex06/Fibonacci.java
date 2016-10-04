/*練習1.6:練習問題1.3で作成したプログラムを修正して、
 * タイトルに対して名前付文字列定数を使用するように修正しなさい*/

package jpl.ch01.ex06;

public class Fibonacci {

	static final String title = "Fibonacci";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**値が50未満のフィボナッチ数列を表示する*/
		
		int lo = 1;
		int hi = 1;
		System.out.println(title);
		System.out.println(lo);
		
		while(hi < 50){
			System.out.println(hi);
			hi = lo + hi;	//新しいhi
			lo = hi - lo;	/*新しいloは、（合計 - 古いlo）
			 					すなわち、古いhi*/
		}
	}

}
