/*練習1.9:Fibonacciアプリケーションを修正して、数列を配列に保存して、
 * 最後に値のリストを表示させるようにしなさい*/

package jpl.ch01.ex09;

public class Fibonacci {
	
	public static final String title = "Fibonacci";
	public static final int ARY_SIZE = 9;//配列サイズ
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**値が50未満のフィボナッチ数列を表示する*/
		
		int lo = 1;
		int hi = 1;
		int[] aryF = new int[ARY_SIZE];//値を格納する配列
		int idx = 0;
		
		aryF[idx] = lo;
		idx++;
		
		/*配列aryFに格納*/
		while(hi < 50){
			aryF[idx] = hi;
			hi = lo + hi;	//新しいhi
			lo = hi - lo;	/*新しいloは、（合計 - 古いlo）
			 					すなわち、古いhi*/
			idx++;
		}
		
		/*表示*/
		System.out.println(title);
		for(int i = 0; i < ARY_SIZE ; i++){
			System.out.println(aryF[i]);
		}
		
	}

}
