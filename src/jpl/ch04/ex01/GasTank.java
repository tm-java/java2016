package jpl.ch04.ex01;

public class GasTank implements EnergySource {

	private int gas;//0~100L
	private static final int MAX = 100;
	
	public GasTank(){
	}
	
	public GasTank(int c){
		setGas(c);
	}
	
	/**ガスタンクの中が空かどうか判定する*/
	@Override
	public boolean empty() {
		if (gas > 0) return false;
		return true;
	}
	
	
	/**セッター*/
	public void setGas(int c){
		if(MAX < c) gas = MAX;
		else if(0 > c) gas = 0;
		else gas = c;
	}
	
	/**ゲッター*/
	public int getGas(){
		return gas;
	}

}
