package jpl.ch04.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class TestLinkedListImplTest {

	@Test
	public void test() {
		String[] expected = new String[] {
				"***********test int**********",
				"list size : 3",
				"2",
				"1",
				"0",
				"",
				"list size : 2",
				"2",
				"0",
				"",
				"list size : 2",
				"2",
				"0",
				"",
				"list size : 1",
				"2",
				"",
				"list size : 0",
				"",
				"***********test ColorAttr**********",
				"list size : 3",
				"no color = 'transparent' (r : null, g : null, b : null)",
				"GREEN = 'green' (green)",
				"RED = 'red' (red)",
				"",
				"list size : 2",
				"no color = 'transparent' (r : null, g : null, b : null)",
				"RED = 'red' (red)",
				"",
				"list size : 2",
				"no color = 'transparent' (r : null, g : null, b : null)",
				"RED = 'red' (red)",
				"",
				"list size : 1",
				"no color = 'transparent' (r : null, g : null, b : null)",
				"",
				"list size : 0"

};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		TestLinkedListImpl.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
