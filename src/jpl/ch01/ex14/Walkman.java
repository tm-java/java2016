package jpl.ch01.ex14;

/**初代ウォークマン*/
public class Walkman {
	private final int id;		//識別番号
	private Speaker output;//出力モジュール
	private int data;		//読み取った単位時間の音楽データ
	private boolean button_start;//スタートボタン	true:ON false:OFF
	private boolean button_stop;//ストップボタン	true:ON false:OFF
	private boolean button_rewind;//巻き戻しボタン	true:ON false:OFF
	private int volume;		//音のボリューム		0~100
	
	public Walkman(int id_){
		id = id_;
		output = new Speaker();
		data = 0;
		button_start = false;
		button_stop = true;
		button_rewind = false;
		volume = 50;
	}
	
	/**出力モジュールの制御*/
	public void controlOutput(){
		output.controlLR(data);
	}
	
	/**カセットの制御*/
	public void controlCassette(){
	}
	
	/**カセットテープの値を読み取る*/
	public int readData(){
		/*処理*/
		return data;
	}
	
	/**スタートボタンを押した処理*/
	public void OnButtonStart(){
		setButtonStart(true);
		setButtonStop(false);
		setButtonRewind(false);
		
		//処理
	}
	
	/**ストップボタンを押した処理*/
	public void OnButtonStop(){
		setButtonStart(false);
		setButtonStop(true);
		setButtonRewind(false);
		
		//処理
	}
	
	/**巻き戻しボタンを押した処理*/
	public void OnButtonRewind(){
		setButtonStart(false);
		setButtonStop(false);
		setButtonRewind(true);
		
		//処理
	}
	
	
	/**カセットが最後まで行ったかいなか*/
	public boolean isEnd(){
		boolean b=true;
		//処理
		return b;
	}
	/**idの値を取得する*/
	public int getId(){
		return id;
	}
	
	/**音楽データを取得する*/
	public int getData(){
		return data;
	}
	
	public boolean getButtonStart(){
		return button_start;
	}
	
	public boolean getButtonStop(){
		return button_stop;
	}
	
	public boolean getButtonRewind(){
		return button_rewind;
	}
	
	public int getVolume(){
		return volume;
	}
	
	public void setData(int d){
		data = d;
	}
	
	public void setButtonStart(boolean b){
		button_start = b;
	}
	
	public void setButtonStop(boolean b){
		button_stop = b;
	}
	
	public void setButtonRewind(boolean b){
		button_rewind = b;
	}
	
	public void setVolume(int v){
		if(v >= 0 && v <= 100){
			volume = v;
		}else {
			//何もしない
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Walkman w = new Walkman(12345);
		//処理
	}
	
}
