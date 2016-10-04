/*練習1.8:Pointクラスにメソッドを追加して、引数として渡されたオブジェクトの座標を
 * 自分の座標に設定するメソッドを定義しなさい*/

package jpl.ch01.ex08;

public class Point {
	public double x,y;	//x,y座標
	
	/**練習1.8:引数として渡されたオブジェクトの座標を自分の座標に設定するメソッド*/
	public void move(Point p){
		this.x = p.x;
		this.y = p.y;
	}
	
	@Override
	public String toString() {
		return "Point [x=" + this.x + ", y=" + this.y +"]";
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Point p1 = new Point();//コピー元
		Point p2 = new Point();//コピー先
		
		p1.x = 1.0;
		p1.y = 2.0;
		
		p2.move(p1);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());

	}

}
