package java8.ch01.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class MyRunnableTest {
	private String str;

	@Test
	public void test() {
		str = "a";
		String expected = "abc";
		
		new Thread(MyRunnable.andThen(
				() -> {str += "b";}, 
				() -> {str += "c";})).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		assertEquals(expected, str);
		
	}

}
