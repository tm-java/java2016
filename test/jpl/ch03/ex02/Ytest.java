package jpl.ch03.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class Ytest {

	@Test
	public void test() {
		String[] expected = new String[] {	
				"xMask    yMask    fullMask",
				 "  ff        0        0",
				 "  ff        0       ff",
				 "  ff     ff00       ff",
				 "  ff     ff00     ffff"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		Y.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
