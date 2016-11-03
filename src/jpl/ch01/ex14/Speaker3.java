package jpl.ch01.ex14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Speaker3 extends Speaker2 implements SpeakerInterface{
	private String mike_data;//マイクから拾ってきた音声データ
	
	public void controlSpeaker(String data){
		super.controlSpeaker(data);
		System.out.println();
		inputMakeData();
		System.out.println("	control mike1 : " + mike_data);
		inputMakeData();
		System.out.println("	control mike2 : " + mike_data);
		System.out.println();
	}
	
	public void inputMakeData(){
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		System.out.print("	input mike data >> ");
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
