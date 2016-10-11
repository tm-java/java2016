package jpl.ch01.ex14;

/**２端子ついた２代目のウォークマン*/
public class WalkmanVer2 extends Walkman{

	private Speaker output2;
	
	public WalkmanVer2(int id_) {
		super(id_);
		Speaker output2 = new Speaker();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void controlOutput(){
		super.controlOutput();
		output2.controlLR(super.getData());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WalkmanVer2 w = new WalkmanVer2(12345);
		//処理
	}
	
	
	
}
