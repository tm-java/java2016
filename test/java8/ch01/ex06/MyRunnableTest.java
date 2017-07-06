package java8.ch01.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyRunnableTest {

	@Test
	public void test() {
		new Thread(MyRunnable.uncheck(() -> {
			System.out.println("Zzz");
			Thread.sleep(1000);
		})).start();
	}

}
