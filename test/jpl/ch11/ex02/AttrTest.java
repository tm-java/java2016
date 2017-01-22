package jpl.ch11.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class AttrTest {

	@Test
	public void test() {
		//main
		String[] expected = new String[] {
			"a = \'aa\'",
			"b = \'1\'",
		};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		Attr.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
