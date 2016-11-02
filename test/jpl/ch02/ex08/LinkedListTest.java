package jpl.ch02.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class LinkedListTest {

	//引数なしコンストラクタ
	@Test
	public void testLinkedList() {
		LinkedList l = new LinkedList();
		assertNotNull(l);
	}
	
	//引数ありコンストラクタ
	@Test
	public void testLinkedListC() {
		String test_data = "test";
		LinkedList test_l = new LinkedList();
		
		LinkedList l = new LinkedList(test_data,test_l);
		assertNotNull(l);
		assertEquals(test_data,l.data);
		assertEquals(test_l,l.next);
	}
	
	
	//Main
	@Test
	public void testMain() {
		String[] expected = new String[] {	"ID : 4 [400km/h, 40Cº, Mr.4]",
				"ID : 3 [300km/h, 30Cº, Mr.3]",
				"ID : 2 [200km/h, 20Cº, Mr.2]",
				"ID : 1 [100km/h, 10Cº, Mr.1]",
				"ID : 0 [0km/h, 0Cº, Mr.0]"
				};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		LinkedList.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}
