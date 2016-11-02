package jpl.ch01.ex14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Headset extends Speaker {
	private String mike_data;//マイクから拾ってきた音声データ
	
	public void controlHedset(int data){
		super.controlSpeaker(data);
		System.out.println("control mike : " + mike_data);
		super.controlSpeaker(mike_data);
	}
	
	public void inputMakeData(){
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		System.out.print("input mike data >> ");
		String str;
		try {
			str = br.readLine();
			mike_data = str;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
