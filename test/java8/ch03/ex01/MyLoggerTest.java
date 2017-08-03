package java8.ch03.ex01;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import org.junit.Test;

public class MyLoggerTest {

	@Test
	public void test() {
		Logger logger = Logger.getLogger("MyLoggerTest");
		logger.addHandler(new StreamHandler() {
			{
				setOutputStream(System.out);
				setLevel(Level.ALL);
			}
		});
		logger.setUseParentHandlers(false);
		MyLogger mlogger = new MyLogger(logger, Level.ALL);
		
		int[] a = { 10, 1, 2, 10, 3, 4, 10, 5, 10, 6, 7 };
		for (int i : a) {
			mlogger.logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10]);
		}
	}

}
