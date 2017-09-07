package java8.ch02.ex10;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class MyDoubleTest {

	@Test
	public void test() {
		//もう少し大きなデータ出ないと、パラレルで実行されていないかも知れない
		double result = MyDouble.average(Stream.of(1.0, 2.0, 3.0, 4.0, 5.0));
		assertTrue((3.0 - result) < 0.000001);
	}

}
