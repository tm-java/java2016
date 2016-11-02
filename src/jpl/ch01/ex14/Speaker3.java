package jpl.ch01.ex14;

public class Speaker3{
	private Headset person1;
	private Headset person2;
	
	public Speaker3(){
		person1 = new Headset();
		person2 = new Headset();
	}
	
	public void controlSpeaker(int data){
		person1.controlSpeaker(data);
		person2.controlSpeaker(data);
	}
	
	public void contlrolHeadset(int data){
		person1.imputMakeData();
		person1.controlHedset(data);
		person2.setMakeData(md);
		person2.controlHedset(data);
	}
}
