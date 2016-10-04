/*練習1.4:なんらかの数列を生成するプログラムを作成しなさ。例えば平方表とか*/

package jpl.ch01.ex04;

public class Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**値が50以下の平方数を表示するプログラム*/
		
		int i = 1;
		
		while((i*i)<50){
			System.out.println(i+" : "+i*i);
			i++;
		}

	}

}
