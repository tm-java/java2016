package jpl.ch03.ex04;

public class Vehicle {

	private int speed;//スピード
	private int angle;//角度
	private String owner;//持ち主の名前
	
	private long ID;		//識別番号
	private static long nextID = 0;//次の識別番号
	private static long maxID = 0; //IDの最大値を保存
	
	final static int FIVE = 5;
	final static boolean TURN_RIGHT = true;
	final static boolean TURN_LEFT = false;
	
	
	public Vehicle(){
		UpMaxID();	//maxIDの更新
		ID = nextID++;
	}
	
	public Vehicle(String name){
		this();
		owner = name;
	}
	
	//今まで使われた識別番号の最大値を更新
	//IDの最大値を求めるメソッドをfinal
	public final void UpMaxID(){
		if(maxID < nextID ) {
			maxID = nextID;
		}
	}
	
	@Override
	public String toString(){
		String rtn = "ID : "+ ID; 
		rtn += ", speed : " + speed;
		rtn += ", angle : " + angle;
		rtn += ", owner : "+ owner;
		
		return rtn;
	}
	
	//引数で渡された値にスピードを変更する
	public void changeSpeed(int s){
		this.setSpeed(s);
	}
	
	//スピードをゼロにする
	//どの乗り物であっても、止まればスピードがゼロになるのでfinalとする
	public final void stop(){
		this.setSpeed(0);
	}
	
	//引数として回転する角度を受け取る
	public void turn(int a){
		this.setAngle(this.angle+a);
	}
	
	//引数として定数TURN_RIGHTかTURN_LEFTを受け取る
	public void turn(boolean b){
		if(b==Vehicle.TURN_RIGHT) {
			this.setAngle(this.angle+90);
		}else {
			this.setAngle(this.angle-90);
		}
		
	}
	
	
	//セッター
	//IDに関するセッターは持つべきではない
	//【理由】IDは一度値が決められたあとは変更する必要がないため
	public void setSpeed(int s){
		if(s>=0) this.speed = s;
	}
	
	public void setAngle(int a){
		if(a>=0){
			this.angle = a%360;
		}else {
			this.angle = a%360 + 360;
		}
	}
	
	public void setOwner(String o){
		this.owner = o;
	}
		
	//ゲッター
	//ゲッターはすべてのフィールドに対して用意する
	//各フィールドのゲッターは変更する必要がないためfinalとする
	public final int getSpeed(){
		return this.speed;
	}
	
	public final int getAngle(){
		return this.angle;
	}
	
	public final String getOwner(){
		return this.owner;
	}
	
	public final long getID(){
		return this.ID;
	}
	
	public static final long getMaxID(){
		return maxID;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle v = new Vehicle(args[0]);
		v.setSpeed(100);
		v.setAngle(450);
		System.out.println(v.toString());				

	}
}
