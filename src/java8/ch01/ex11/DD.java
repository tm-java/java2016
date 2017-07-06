package java8.ch01.ex11;

public class DD implements ID, JD {
	//コンパイルエラー、IDか、JDのオーバーライドかどちらかを求められる
	@Override
	public void f() {
		ID.super.f();
	}
	
}
