package jpl.ch21.ex05;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class ArrayBunchListTest {

	ArrayBunchList<String> test;
	String[][] input = {
			{
				"a", "b", "c", "d"
			},
			{
				"e", "f", "g"
			},
			{
				"h"
			},
			{
				"i", "j"
			}
	};
	

	@Test
	public void testNext() {
		test = new ArrayBunchList<String>(input);
		ListIterator actual = test.listIterator();
		List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		ListIterator expectedi = expected.listIterator();
		
		while (actual.hasNext()) {
			assertEquals(expectedi.next(), actual.next());
		}
		assertFalse(expectedi.hasNext());
	}

	@Test
	public void testPre() {
		test = new ArrayBunchList<String>(input);
		ListIterator actual = test.listIterator();
		List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		ListIterator expectedi = expected.listIterator();
		
		while (actual.hasNext()) {
			actual.next();
			expectedi.next();
		}
		
		while (actual.hasPrevious()) {
			assertEquals(expectedi.previous(), actual.previous());
		}
		assertFalse(expectedi.hasPrevious());
	}

	@Test
	public void testNextIndex() {
		test = new ArrayBunchList<String>(input);
		ListIterator actual = test.listIterator();
		List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		ListIterator expectedi = expected.listIterator();
		
		while (actual.hasNext()) {
			assertEquals(expectedi.next(), actual.nextIndex());
			actual.next();
		}
		assertEquals(expectedi.next(), actual.nextIndex());
	}

	@Test
	public void testPreIndex() {
		test = new ArrayBunchList<String>(input);
		ListIterator actual = test.listIterator();
		List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		ListIterator expectedi = expected.listIterator();
		
		while (actual.hasNext()) {
			actual.next();
			expectedi.next();
		}
		while (actual.hasPrevious()) {
			assertEquals(expectedi.previous(), actual.previousIndex());
			actual.previous();
		}
		assertEquals(-1, actual.previousIndex());
	}
	
	@Test
	public void testSet1() {
		test = new ArrayBunchList<String>(new String[][]{{"a"}});
		ListIterator actual = test.listIterator();

		actual.next();
		actual.set("b");
		assertEquals("b", test.get(0));
	}

	@Test(expected = IllegalStateException.class)
	public void testSet2() {
		test = new ArrayBunchList<String>(new String[][]{{"a"}});
		ListIterator actual = test.listIterator();

		actual.set("b");
		
	}

}
