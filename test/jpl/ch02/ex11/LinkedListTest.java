package jpl.ch02.ex11;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;
import jpl.ch02.ex10.Vehicle;

public class LinkedListTest {

	
	@Test
	public void test() {
		
		//toString
		String expected = "ID : 0, speed : 0, angle : 0, owner : test";
		LinkedList l = new LinkedList();
		l.data = new Vehicle("test");
		
		assertEquals(expected,l.toString());
		
		
		//main
		String[] expectedMain = new String[] {	"ID : 5, speed : 400, angle : 40, owner : Mr.4",
				"ID : 4, speed : 300, angle : 30, owner : Mr.3",
				"ID : 3, speed : 200, angle : 20, owner : Mr.2",
				"ID : 2, speed : 100, angle : 10, owner : Mr.1",
				"ID : 1, speed : 0, angle : 0, owner : Mr.0"
				};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		LinkedList.main(new String[0]);

		sc.stop();
		sc.assertEquals(expectedMain);
	}

}
