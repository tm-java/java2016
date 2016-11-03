package jpl.ch01.ex14;

import java.io.IOException;

/**２端子ついた２代目のウォークマン*/
public class WalkmanVer2 extends Walkman{
	
	public WalkmanVer2(int id_) {
		super(id_);
		output = new Speaker2();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WalkmanVer2 w2 = new WalkmanVer2(12345);
		
		try {
			w2.controlWalkman();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
