package jpl.ch01.ex14;

public class Speaker2 extends Speaker{
	
	public void controlSpeaker(int data){
		super.controlSpeaker(data);
		System.out.println("control Speaker2 : " + data);
	}

}
