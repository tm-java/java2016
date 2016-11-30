package jpl.ch03.ex08;

public class Battery extends EnergySource implements Cloneable {

	private int battery;//0~100
	private static final int MAX = 100;
	
	public Battery(){
		
	}
	
	public Battery(int b){
		setBattery(b);
	}
	
	/**バッテリーが空かどうか判定する*/
	@Override
	public boolean empty() {
		if(battery > 0) return false;
		return true;
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
	
	public Battery clone() throws CloneNotSupportedException{
		return (Battery) super.clone();
	}
}
