package jpl.ch03.ex12;

public class Point implements Comparable<Point> {
	
	private static final Point ORIGIN = new Point();
	
	private int x,y;
	
	public Point(){}
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void moveTo(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point p){
		int xdiff = x - p.x;
		int ydiff = y - p.y;
		return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
	}
	
	public int compareTo(Point p){
		double pDist = p.distance(ORIGIN);
		double dist = this.distance(ORIGIN);
		if(dist > pDist) return 1;
		else if (dist == pDist) return 0;
		else return -1;
	}
	
	
	public static void main(String[] args){
		Point[] list = new Point[5];
		//配列の要素を格納
		for(int i=0;i<5;i++){
			list[i]= new Point(5-i,5-i);
		}
		
		//表示
		for(int i=0;i<5;i++){
			System.out.println("("+((Point)list[i]).getX()+", "+((Point)list[i]).getY()+")");		
		}
		
		//ソート
		SortHarness.sort(list);
		
		//表示
		for(int i=0;i<5;i++){
			System.out.println("("+((Point)list[i]).getX()+", "+((Point)list[i]).getY()+")");		
		}
		
		
	}

}
