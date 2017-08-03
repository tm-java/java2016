package java8.ch03.ex16;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class MyExceptionTest {

	@Test
	public void test() {
		String expected = "test!!";
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		MyException.doInOrderAsync(
				() -> {throw new RuntimeException("test!!");},
				(t, u) -> {System.out.println(u.getMessage());});
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sc.stop();
		sc.assertEquals(expected);
		
	}

}
