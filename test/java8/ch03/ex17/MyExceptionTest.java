package java8.ch03.ex17;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class MyExceptionTest {

	@Test
	public void test1() {
		String expected = "test!!";
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		MyException.doInOrderAsync(() -> {
		}, () -> {
			throw new RuntimeException("test!!");
		}, (t) -> {
			System.out.println(t.getMessage());
		});
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sc.stop();
		sc.assertEquals(expected);

	}

	@Test
	public void test2() {
		
		String expected = "test!!";
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		MyException.doInOrderAsync(() -> {
			throw new RuntimeException("test!!");
		}, () -> {
		}, (t) -> {
			System.out.println(t.getMessage());
		});
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sc.stop();
		sc.assertEquals(expected);
	}

}
