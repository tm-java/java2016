package jpl.ch11.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class LinkedListTest {

	@Test
	public void test() {
	//main
		String[] expected = new String[] {
				"9",
				"8",
				"7",
				"6",
				"5",
				"4",
				"3",
				"2",
				"1",
				"0",
		};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		LinkedList.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
