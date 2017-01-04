package jpl.ch10.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class PascalsTriangleDoWhileTest {

	@Test
	public void testNew() {
		PascalsTriangleDoWhile test = new PascalsTriangleDoWhile(12);
		assertNotNull(test);	
	}
	
	@Test
	public void testMain() {
		String[] expected = new String[] {
				"pascal's triangle with depth of 12",
				"1 ",
				"1 1 ",
				"1 2 1 ",
				"1 3 3 1 ",
				"1 4 6 4 1 ",
				"1 5 10 10 5 1 ",
				"1 6 15 20 15 6 1 ",
				"1 7 21 35 35 21 7 1 ",
				"1 8 28 56 70 56 28 8 1 ",
				"1 9 36 84 126 126 84 36 9 1 ",
				"1 10 45 120 210 252 210 120 45 10 1 ",
				"1 11 55 165 330 462 462 330 165 55 11 1 ",
				"pascal's triangle with depth of 5",
				"1 ",
				"1 1 ",
				"1 2 1 ",
				"1 3 3 1 ",
				"1 4 6 4 1 ",
			};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
				
		PascalsTriangleDoWhile.main(new String[0]);
				
		sc.stop();
		sc.assertEquals(expected);	
	}

}
