package jpl.ch07.ex02;

public class LiteralPractice {
	
	byte    byte_;
	short   short_;
	int     int_;
	long    long_;
	float   float_;
	double  double_;
	

	public void bytePractice(){
		byte_ = 1; //int:代入可
		//byte_ = 1L; long:コンパイルエラー
		//byte_ = 1.0f; float:コンパイルエラー
		//byte_ = 1.0; double:コンパイルエラー
		byte_ = 0x11; //int8ビット:代入可
		//byte_ = 0x111; int12ビット:コンパイルエラー 
	}
	
	public void intPractice(){
		int_ = 1; //int:代入可
		//int_ = 1L; //long:コンパイルエラー
		//int_ = 1.0f; //float:コンパイルエラー
		//int_ = 1.0; //double:コンパイルエラー
		int_ = 0x11111111; //int32ビット:代入可 
		//int_ = 0x111111111; //36ビット:コンパイルエラー 
	}
	
	public void longPractice(){
		long_ = 1; //int:代入可
		long_ = 1L; //long:代入可
		//long_ = 1.0f; //float:コンパイルエラー
		//long_ = 1.0; //double:コンパイルエラー
		//long_ = 0x11111111111111; //int64ビット:コンパイルエラー 
		long_ = 0x1111111111111111L; //long64ビット:代入可 
		//long_ = 0x11111111111111111L; //long68ビット:コンパイルエラー 
	}
	
	public void floatPractice(){
		float_ = 1; //int:代入可
		float_ = 1L; //long:代入可
		float_ = 1.0f; //float:代入可
		//float_ = 1.0; //double:コンパイルエラー
		//float_ = 0x111111111111111111111111111111111111f; //コンパイルエラー
		float_ = 0x1111111111111111L; //long64ビット:代入可 
		//float_ = 0x11111111111111111L; //long68ビット:コンパイルエラー 
	}
	
	public void doublePractice(){
		double_ = 1; //int:代入可
		double_ = 1L; //long:代入可
		double_ = 1.0f; //float:代入可
		double_ = 1.0; //double:代入可
		double_ = 0x111111111111111111111111111111111111111111111111111p+8; //代入可 
		//double_ = 0x11111111111111111L; //long68ビット:コンパイルエラー 
	}
	
	
	
}
