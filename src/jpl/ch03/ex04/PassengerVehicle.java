package jpl.ch03.ex04;

import jpl.ch02.ex18.Vehicle;

public class PassengerVehicle extends Vehicle{
	private int sheets;		//0以上
	private int passengers; //0~sheets
	
	public PassengerVehicle(){
		super();
	}
	
	public PassengerVehicle(String name,int s){
		super(name);
		setSheets(s);
	}
	
	public PassengerVehicle(String name,int s,int p){
		super(name);
		setSheets(s);
		setPassengers(p);
	}
	
	/**0~sheetsの値をセットする*/
	public void setPassengers(int p){
		if(p>sheets) passengers = sheets;
		else if(p<0) passengers = 0;
		else 		 passengers = p;
	}
	
	/**0以上の値をセットする*/
	public void setSheets(int s){
		if(s<0) sheets = 0;
		else	sheets = s;
		
		//座席数と座っている人数に矛盾のないように調整する
		setPassengers(passengers);
	}
	
	//ゲッターはfinal
	public final int getPassengers(){
		return passengers;
	}
	
	public final int getSheets(){
		return sheets;
	}
	
	public String toString(){
		String r = super.toString();
		r += ", sheets : " + sheets;
		r += ", passengers : " + passengers;
		return r;
	}

	public static final void main(String[] args){
		PassengerVehicle p1 = new PassengerVehicle("p1",5,3);
		p1.setSpeed(100);
		p1.setAngle(90);
		
		PassengerVehicle p2 = new PassengerVehicle("p2",2);
		p2.setPassengers(2);
		p2.setSpeed(200);
		p2.setAngle(180);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		
	}
}

