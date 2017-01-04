package jpl.ch10.ex04;

public class PascalsTriangleWhile {

	private int depth;	//深さ（課題では定数であったが、深さを後から指定できるよう変更）
	private int[][] pTriangle;
	
	/**パスカルの三角形生成*/
	public PascalsTriangleWhile(int d){
		
		//コンスコラクタの引数として、深さをとる
		//適切でない値の場合、12を初期値とする
		if(d>0) depth = d;
		else depth = 12;
		
		//パスカルの三角形生成
		pTriangle = new int[depth][];
		
		int i = 0;
		while(i<depth){	
			pTriangle[i] = new int[i+1];
			int j=0;
			while(j<(i+1)){
				if(j==0) 		pTriangle[i][j] = 1;
				else if(j==i) 	pTriangle[i][j] = 1;
				else 			pTriangle[i][j] = pTriangle[i-1][j-1] + pTriangle[i-1][j];
			
				j++;
			}
			i++;
		}
		
	}
	
	/**パスカルの三角形を表示する*/
	public void displayPascalsTriangle(){
		int i=0;
		while(i<pTriangle.length){
			int j=0;
			while(j<pTriangle[i].length){
				System.out.print(pTriangle[i][j]+" ");
				j++;
			}
			System.out.println();
			i++;
		}
	}
	
	public static void main(String[] args){
		PascalsTriangleWhile p12 = new PascalsTriangleWhile(12);
		PascalsTriangleWhile p5 = new PascalsTriangleWhile(5);
		System.out.println("pascal's triangle with depth of 12");
		p12.displayPascalsTriangle();
		System.out.println("pascal's triangle with depth of 5");
		p5.displayPascalsTriangle();
	}
	
	

}
