package jpl.ch01.ex14;

/**初代ウォークマン*/
public class Walkman {
	private final int id;		//識別番号
	private Speaker output;//出力モジュール
	private int data;		//読み取った単位時間の音楽データ
	
	
	public Walkman(int id_){
		id = id_;
		output = new Speaker();
		data = 0;
	}
	
	/**出力モジュールの制御*/
	public void controlOutput(){
		
		output.controlSpeaker(data);
	}
		
	/**カセットテープの値を読み取る*/
	public int readData(){
		/*処理*/
		return data;
	}
	
	
	
	
	/**idの値を取得する*/
	public int getId(){
		return id;
	}
	
	/**音楽データを取得する*/
	public int getData(){
		return data;
	}
	
	public void setData(int d){
		data = d;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Walkman w = new Walkman(12345);
		//処理
	}
	
}
