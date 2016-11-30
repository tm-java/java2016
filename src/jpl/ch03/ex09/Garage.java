package jpl.ch03.ex09;

import jpl.ch03.ex08.Vehicle;
import jpl.ch03.ex08.GasTank;
import jpl.ch03.ex08.Battery;

public class Garage implements Cloneable {
	private Vehicle[] vehicles;
	private int size;
	
	public Garage(int maxContents){
		size = maxContents;
		vehicles = new Vehicle[size];
		for(int i=0;i<size;i++){
			vehicles[i] = new Vehicle(); 
		}
	}
	
	
	public String toString(){
		String rtn="";
		for(int i=0;i<size;i++){
			rtn += "vehicle[" +i + "] (" +vehicles[i].toString() + ") ";
		}
		return rtn;
	}

	public Garage clone() throws CloneNotSupportedException {
		Garage rtn = (Garage) super.clone();
		rtn.vehicles = new Vehicle[size];
		for(int i=0;i<size;i++){
			rtn.vehicles[i] = vehicles[i].clone();
		}
		return rtn;
	}
	
	public static void main(String[] args){
		Garage g = new Garage(2);
		g.vehicles[0].setOwner("g1");
		g.vehicles[1].setOwner("g2");
		try {
			Garage cln = g.clone();
			cln.vehicles[0].changeSpeed(100);
			System.out.println(g.toString());
			System.out.println(cln.toString());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
