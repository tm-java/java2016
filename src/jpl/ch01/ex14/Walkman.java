package jpl.ch01.ex14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**初代ウォークマン*/
public class Walkman {
	private final int id;		//識別番号
	private String path = "src/jpl/ch01/ex14/song_data";
	
	protected SpeakerInterface output;//出力モジュール
	private String data;		//読み取った単位時間の音楽データ
	
	
	public Walkman(int id_){
		id = id_;
		output = new Speaker();
	}
	
	public void controlWalkman() throws IOException{
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		data = br.readLine();
		while(data != null){
			output.controlSpeaker(data);
			
			data = br.readLine();
		}
		br.close();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Walkman w = new Walkman(1234);
		
		try {
			w.controlWalkman();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
