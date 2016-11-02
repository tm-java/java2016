package jpl.ch02.ex07;

public class Vehicle {
	
	public int speed;//スピード
	public int angle;//角度
	public String owner;//持ち主の名前
	
	public long ID;		//識別番号
	public static long nextID = 0;//次の識別番号
	
	final static int FIVE = 5;
	
	public Vehicle(){
		ID = nextID++;
	}
	
	public Vehicle(String name){
		this();
		owner = name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle[] vcls = new Vehicle[FIVE];
		
		//データの格納
		for(int i=0;i<FIVE;i++){
			Vehicle v = new Vehicle(i+"san");
			v.speed = 100+i;
			v.angle = 10+i;
	
			vcls[i] = v;
		}
		
		//表示
		for(int i=0;i<FIVE;i++){
			Vehicle v = vcls[i];
			System.out.print("ID : " + v.ID);
			System.out.println(" ["+v.speed + "km/h, "+v.angle+"Cº, "+v.owner+"]");
		}

	}

}
