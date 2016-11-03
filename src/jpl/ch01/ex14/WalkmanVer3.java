package jpl.ch01.ex14;

import java.io.IOException;

/**２端子モデルで双方向コミュニケーションを可能にした３代目*/
public class WalkmanVer3 extends WalkmanVer2{

	public WalkmanVer3(int id_) {
		super(id_);
		output = new Speaker3();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WalkmanVer3 w3 = new WalkmanVer3(12345);
		
		try {
			w3.controlWalkman();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
