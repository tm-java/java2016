package jpl.ch22.ex04;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class LibraryTest {

	@Test
	public void test() {
		Library library = new Library();
		User tester = new User("tester");
		User tester2 = new User("tester2");
		tester.addBooks(library.JPL);
		tester2.addBooks(library.JAVA_8);
		
		
		String[] expected = {
			"tester2 borrows 'Java 8'",
			"tester borrows 'JPL'"
		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		library.returnBook(library.JAVA_8);
		library.returnBook(library.JPL);

		sc.stop();
		sc.assertEquals(expected);
		
	}

}
