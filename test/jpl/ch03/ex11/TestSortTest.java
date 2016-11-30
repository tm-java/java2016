package jpl.ch03.ex11;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class TestSortTest {

	@Test
	public void test() {
		//main
		String[] expected = new String[] {
				"Metrics: 0 probes 6 compares 2 swaps",
				"\t0.013",
				"\t0.3",
				"\t3.17",
				"\t7.9"
				
		};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		TestSort.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
