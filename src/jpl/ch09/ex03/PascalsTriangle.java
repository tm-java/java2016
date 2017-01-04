package jpl.ch09.ex03;

public class PascalsTriangle {
	private int depth;	//深さ（課題では定数であったが、深さを後から指定できるよう変更）
	private int[][] pTriangle;
	
	/**パスカルの三角形生成*/
	public PascalsTriangle(int d){
		
		//コンスコラクタの引数として、深さをとる
		//適切でない値の場合、12を初期値とする
		if(d>0) depth = d;
		else depth = 12;
		
		//パスカルの三角形生成
		pTriangle = new int[depth][];
		
		for(int i=0;i<depth;i++){	
			pTriangle[i] = new int[i+1];
			pTriangle[i][0] = pTriangle[i][i] = 1;
			for(int j=1;j<i;j++){
				pTriangle[i][j] = pTriangle[i-1][j-1] + pTriangle[i-1][j];
			}
		}
	}
	
	/**パスカルの三角形を表示する*/
	public void displayPascalsTriangle(){
		for(int i=0;i<pTriangle.length;i++){
			for(int j=0;j<pTriangle[i].length;j++){
				System.out.print(pTriangle[i][j]+" "+(j==(pTriangle[i].length-1)?"\n":""));
			}
			//System.out.println();
		}
	}
	
	public static void main(String[] args){
		PascalsTriangle p12 = new PascalsTriangle(12);
		PascalsTriangle p5 = new PascalsTriangle(5);
		System.out.println("pascal's triangle with depth of 12");
		p12.displayPascalsTriangle();
		System.out.println("pascal's triangle with depth of 5");
		p5.displayPascalsTriangle();
	}
	
	

}
