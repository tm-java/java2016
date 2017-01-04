package jpl.ch09.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class MyBitCountTest {

	@Test
	public void test() {
		String[] expected = new String[] {
				"myBitCount(1) 		:1",
				"Integer.bitCount(1) 	:1",
				"myBitCount(-1) 		:32",
				"Integer.bitCount(-1) 	:32",
				"myBitCount(255) 	:8",
				"Integer.bitCount(255) 	:8",
		};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
				
		MyBitCount.main(new String[0]);
				
		sc.stop();
		sc.assertEquals(expected);	
	}

}
