package jpl.ch01.ex14;

public class Speaker implements SpeakerInterface{
	
	/**スピーカーを制御する*/
	public void controlSpeaker(String data){
		System.out.println("cntrol Speaker : " + data);
	}
	
}
