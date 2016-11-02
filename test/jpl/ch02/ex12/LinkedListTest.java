package jpl.ch02.ex12;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;
import jpl.ch02.ex10.Vehicle;

public class LinkedListTest {

	@Test
	public void test() {
		//makeList
		LinkedList header = new LinkedList();
		Vehicle testv1 = new Vehicle("test1");
		Vehicle testv2 = new Vehicle("test2");
		header.makeList(header,testv1,testv2);
		assertEquals(header.next.data, testv2);
		assertEquals(header.next.next.data,testv1);
		
		//main
		String[] expectedMain = new String[] {	"ID : 6, speed : 400, angle : 40, owner : Mr.4",
				"ID : 5, speed : 300, angle : 30, owner : Mr.3",
				"ID : 4, speed : 200, angle : 20, owner : Mr.2",
				"ID : 3, speed : 100, angle : 10, owner : Mr.1",
				"ID : 2, speed : 0, angle : 0, owner : Mr.0"
				};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		LinkedList.main(new String[0]);

		sc.stop();
		sc.assertEquals(expectedMain);
	}

}
