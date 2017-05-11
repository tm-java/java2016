package jpl.ch22.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class EFGFormatTest {

	@Test
	public void test() {
		double[] test = new double[10];
		for (int i = 0; i < 10; i++) {
			test[i] = 1.0 / (i + 1);
		}
		String[] expected = new String[] {
				"1.000",
				"0.500",
				"0.333",
				"0.250",
				"0.200",
				"0.167",
				"0.143",
				"0.125",
				"0.111",
				"0.100"
		};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
				
		EFGFormat.formatDisplay(test, 3);
				
		sc.stop();
		sc.assertEquals(expected);	
		
	}

}
