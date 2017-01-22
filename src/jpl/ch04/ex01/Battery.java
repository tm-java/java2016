package jpl.ch04.ex01;

public class Battery implements EnergySource {

	private int battery;//0~100
	private static final int MAX = 100;
	
	public Battery(){
		
	}
	
	public Battery(int b){
		setBattery(b);
	}
	
	/**バッテリーが空かどうか判定する*/
	//2017.1.6一行で書いて欲しい
	@Override
	public boolean empty() {
		return battery <=0;
		//if(battery > 0) return false;
		//return true;
	}
	
	/**セッター*/
	public void setBattery(int b){
		if(MAX < b) battery = MAX;
		else if(0 > b) battery = 0; 
		else battery = b;
	}
	
	/**ゲッター*/
	public int getBattery(){
		return battery;
	}

}
