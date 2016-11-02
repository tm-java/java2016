package jpl.ch02.ex10;

public class Vehicle {
	public int speed;//スピード
	public int angle;//角度
	public String owner;//持ち主の名前
	
	public long ID;		//識別番号
	public static long nextID = 0;//次の識別番号
	public static long maxID = 0; //IDの最大値を保存
	
	final static int FIVE = 5;
	
	public Vehicle(){
		UpMaxID();	//maxIDの更新
		ID = nextID++;
	}
	
	public Vehicle(String name){
		this();
		owner = name;
	}
	
	//今まで使われた識別番号の最大値を更新
	public void UpMaxID(){
		if(maxID < nextID ) {
			maxID = nextID;
		}
	}
	
	public static long getMaxID(){
		return maxID;
	}
	
	@Override
	public String toString(){
		String rtn = "ID : "+ ID; 
		rtn += ", speed : " + speed;
		rtn += ", angle : " + angle;
		rtn += ", owner : "+ owner;
		
		return rtn;
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
			System.out.println(vcls[i].toString());	
		}
		
		System.out.println("maxID : " + Vehicle.getMaxID());

	}

}
