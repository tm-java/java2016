package jpl.ch02.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class LinkedListTest {

	@Test
	public void testMain() {
		String[] expected = new String[] {	"ID : 0 [0km/h, 0Cº, Mr.0]",
				"ID : 1 [100km/h, 10Cº, Mr.1]",
				"ID : 2 [200km/h, 20Cº, Mr.2]",
				"ID : 3 [300km/h, 30Cº, Mr.3]",
				"ID : 4 [400km/h, 40Cº, Mr.4]"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		LinkedList.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);

	}

}
