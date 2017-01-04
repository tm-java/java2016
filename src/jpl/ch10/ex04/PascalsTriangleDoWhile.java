/**
 * 今回は、do-while文に書き直すこともできるが、書き直さない
 * 処理を一回は必ず行いたい場合以外は、読みにくいため、do-whileは使わない
 * */

package jpl.ch10.ex04;

public class PascalsTriangleDoWhile {

	private int depth;	//深さ（課題では定数であったが、深さを後から指定できるよう変更）
	private int[][] pTriangle;
	
	/**パスカルの三角形生成*/
	public PascalsTriangleDoWhile(int d){
		
		//コンスコラクタの引数として、深さをとる
		//適切でない値の場合、12を初期値とする
		if(d>0) depth = d;
		else depth = 12;
		
		//パスカルの三角形生成
		pTriangle = new int[depth][];
		
		int i = 0;
		do{	
			pTriangle[i] = new int[i+1];
			int j=0;
			do{
				if(j==0) 		pTriangle[i][j] = 1;
				else if(j==i) 	pTriangle[i][j] = 1;
				else 			pTriangle[i][j] = pTriangle[i-1][j-1] + pTriangle[i-1][j];
				j++;
			}while(j<(i+1));
			i++;
		}while(i<depth);
		
	}
	
	/**パスカルの三角形を表示する*/
	public void displayPascalsTriangle(){
		int i=0;
		do{
			int j=0;
			do{
				System.out.print(pTriangle[i][j]+" ");
				j++;
			}while(j<pTriangle[i].length);
			System.out.println();
			i++;
		}while(i<pTriangle.length);
	}
	
	public static void main(String[] args){
		PascalsTriangleDoWhile p12 = new PascalsTriangleDoWhile(12);
		PascalsTriangleDoWhile p5 = new PascalsTriangleDoWhile(5);
		System.out.println("pascal's triangle with depth of 12");
		p12.displayPascalsTriangle();
		System.out.println("pascal's triangle with depth of 5");
		p5.displayPascalsTriangle();
	}
	
	

}
