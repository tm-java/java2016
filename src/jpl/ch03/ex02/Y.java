package jpl.ch03.ex02;

public class Y extends X {
	protected int yMask = 0xff00;
	
	public Y(){
		System.out.printf("%4x     %4x     %4x%n",xMask,yMask,fullMask);
		fullMask |= yMask;
		System.out.printf("%4x     %4x     %4x%n",xMask,yMask,fullMask);
	}
	
	public static final void main(String[] args){
		Y y = new Y();
	}
}
