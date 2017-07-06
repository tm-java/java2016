package java8.ch01.ex11;

public class AD implements IA, JD {
	//コンパイルエラー、IAの実装か、IDのオーバーライドかどちらかを求められる
	
	@Override
	public void f() {
		JD.super.f();
	}
}
