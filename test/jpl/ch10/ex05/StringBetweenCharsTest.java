package jpl.ch10.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class StringBetweenCharsTest {

	@Test
	public void test() {
		//main
		String[] expected = new String[] {
				"abcdefghijklmnopqrstuvwxyz",
				"0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`ab"
		};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		StringBetweenChars.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}
}
