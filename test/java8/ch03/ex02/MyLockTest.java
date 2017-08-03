package java8.ch03.ex02;

import static org.junit.Assert.*;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class MyLockTest {

	@Test
	public void test() {
		String[] name = { "java", "8", "ch03", "ex02" };
		String[] expected = {
			"java", "java!!",
			"8", "8!!",
			"ch03", "ch03!!",
			"ex02", "ex02!!",
		};
		
		Lock lock = new ReentrantLock();
		
		for (String s : name) {
			new Thread(() -> {
				MyLock.withLock(lock, () -> {
					System.out.println(s);
					System.out.println(s + "!!");
					});
			}).start();
		}
		
	}

}
