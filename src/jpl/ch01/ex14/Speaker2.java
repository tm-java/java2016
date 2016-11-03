package jpl.ch01.ex14;

public class Speaker2 extends Speaker implements SpeakerInterface{
	
	public void controlSpeaker(String data){
		super.controlSpeaker(data);
		System.out.println("control Speaker2 : " + data);
	}

}
