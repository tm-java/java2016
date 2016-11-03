package jpl.ch02.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class LinkedListTest {

	//Data
	@Test
	public void testData() {
		LinkedList l = new LinkedList();
		l.setData("test");
		
		assertEquals("test",l.getData());
	}
	
	//Next
	@Test
	public void testNext() {
		LinkedList l = new LinkedList();
		LinkedList nxt = new LinkedList();
		l.setNext(nxt);
		
		assertEquals(nxt,l.getNext());
	}
	
	//Main
	@Test
	public void testMain() {
		String[] expectedMain = new String[] {	"ID : 4, speed : 400, angle : 40, owner : Mr.4",
				"ID : 3, speed : 300, angle : 30, owner : Mr.3",
				"ID : 2, speed : 200, angle : 20, owner : Mr.2",
				"ID : 1, speed : 100, angle : 10, owner : Mr.1",
				"ID : 0, speed : 0, angle : 0, owner : Mr.0"
				};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		LinkedList.main(new String[0]);

		sc.stop();
		sc.assertEquals(expectedMain);
	}
	

}
