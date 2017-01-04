package jpl.ch07.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class UnicodePracticeTest {

	@Test
	public void test() {
		String[] expected = new String[] {"Hello, World"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
				
		UnicodePractice.main(new String[0]);
				
		sc.stop();
		sc.assertEquals(expected);
	}

}
