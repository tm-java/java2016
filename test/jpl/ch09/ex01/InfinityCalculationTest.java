package jpl.ch09.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class InfinityCalculationTest {

	@Test
	public void test() {
		String[] expected = new String[] {
				"x	y	(x+y)		(x-y)		(x*y)		(x/y)",
				"----------------------------------------------------------------------",
				"+∞	+∞	Infinity	NaN		Infinity	NaN",
				"+∞	-∞	NaN		Infinity	-Infinity	NaN",
				"-∞	-∞	-Infinity	NaN		Infinity	NaN",
		};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
				
		InfinityCalculation.main(new String[0]);
				
		sc.stop();
		sc.assertEquals(expected);	

	}

}
