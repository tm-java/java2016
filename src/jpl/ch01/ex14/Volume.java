package jpl.ch01.ex14;

public class Volume {
	private int volume;		//音のボリューム		0~100
	
	public Volume(){
		
	}
	
	public Volume(int v){
		volume = v;
	}
	
	public int getVolume(){
		return volume;
	}
	
	public void setVolume(int v){
		if(v >= 0 && v <= 100){
			volume = v;
		}else {
			//何もしない
		}
	}
	
	public void controlVolume(){
		System.out.println("volume : "+volume);
	}
}
