package jpl.ch10.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class EscapeSequenceTest {

	@Test
	public void test() {
		//main
		String[] expected = new String[] {
			"",
			"	aa",
			"\"abcdefg\"",
			"\'a\'\'b\'",
			"\\<>=!!"
		};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		EscapeSequence.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}


}
