package jpl.ch03.ex10;

import static org.junit.Assert.*;

import org.junit.Test;
import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class LinkedListTest {

	@Test
	public void test() {
		//main
		String[] expected = new String[] {
				"ID : 2, speed : 200, angle : 20, owner : Mr.2",
				"ID : 1, speed : 100, angle : 10, owner : Mr.1",
				"ID : 0, speed : 0, angle : 0, owner : Mr.0",
				"",
				"ID : 2, speed : 200, angle : 20, owner : Mr.2",
				"ID : 1, speed : 100, angle : 10, owner : Mr.1",
				"ID : 0, speed : 0, angle : 0, owner : Mr.0",
				"",
				"クローンのリスト変更",
				"ID : 2, speed : 200, angle : 20, owner : Mr.2",
				"ID : 1, speed : 100, angle : 10, owner : Mr.1",
				"ID : 0, speed : 0, angle : 0, owner : Mr.0",
				"",
				"ID : 0, speed : 0, angle : 0, owner : Mr.0",
				"ID : 1, speed : 100, angle : 10, owner : Mr.1",
				"ID : 0, speed : 0, angle : 0, owner : Mr.0",
				"",
				"クローンの中のオブジェクト変更",
				"ID : 2, speed : 200, angle : 20, owner : Mr.2",
				"ID : 1, speed : 100, angle : 10, owner : Mr.1",
				"ID : 0, speed : 0, angle : 0, owner : aaaaa",
				"",
				"ID : 0, speed : 0, angle : 0, owner : aaaaa",
				"ID : 1, speed : 100, angle : 10, owner : Mr.1",
				"ID : 0, speed : 0, angle : 0, owner : aaaaa"
		};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		LinkedList.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
