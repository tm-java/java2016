package jpl.ch21.ex04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class ShortStringsTest {
	List<String> test;
	
	public void init(){
		test = new ArrayList<String>();
		test.add("a");
		test.add("abc");
		test.add("b");
		test.add("ac");
		test.add("abcde");
	}

	@Test
	public void testNext() {
		init();
		List<String> expected = Arrays.asList("a", "b", "ac");
		ListIterator expectedi = expected.listIterator();
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		while(ss.hasNext()) {
			assertEquals(expectedi.next(), ss.next());
		}
		assertFalse(ss.hasNext());
	}
	
	@Test
	public void testPre() {
		init();
		List<String> expected = Arrays.asList("ac", "b", "a");
		ListIterator expectedi = expected.listIterator();
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		while(ss.hasNext()) {
			ss.next();
		}
		while(ss.hasPrevious()) {
			assertEquals(expectedi.next(), ss.previous());
		}
		assertFalse(ss.hasPrevious());
	}
	
	@Test
	public void testNextIndex() {
		init();
		List<Integer> expected = Arrays.asList(0, 2, 3, 5);
		ListIterator expectedi = expected.listIterator();
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		while(ss.hasNext()) {
			assertEquals(expectedi.next(), ss.nextIndex());
			ss.next();
		}
		assertEquals(expectedi.next(), ss.nextIndex());
	}
	
	@Test
	public void testPreIndex() {
		init();
		List<Integer> expected = Arrays.asList(3, 2, 0, -1);
		ListIterator expectedi = expected.listIterator();
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		while(ss.hasNext()) {
			ss.next();
		}
		while(ss.hasPrevious()) {
			assertEquals(expectedi.next(), ss.previousIndex());
			ss.previous();
		}
		assertEquals(expectedi.next(), ss.previousIndex());
	}
	
	@Test
	public void testRemove1() {
		test = new ArrayList<String>();
		test.add("a");
		
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		
		ss.next();
		ss.remove();
		assertEquals(0, test.size());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testRemove2() {
		test = new ArrayList<String>();
		test.add("a");
		
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		
		ss.remove();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testRemove3() {
		test = new ArrayList<String>();
		test.add("a");
		
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		ss.next();
		ss.add("a");
		ss.remove();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testRemove4() {
		test = new ArrayList<String>();
		test.add("a");
		
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		ss.next();
		ss.remove();
		ss.remove();
	}
	
	@Test
	public void testSet1() {
		test = new ArrayList<String>();
		test.add("a");
		
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		
		ss.next();
		ss.set("b");
		assertEquals("b", test.get(0));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testSet2() {
		test = new ArrayList<String>();
		test.add("a");
		
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		
		ss.set("b");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testSet3() {
		test = new ArrayList<String>();
		test.add("a");
		
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		
		ss.next();
		ss.remove();
		ss.set("b");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testSet4() {
		test = new ArrayList<String>();
		test.add("a");
		
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		
		ss.next();
		ss.add("a");
		ss.set("b");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSet5() {
		test = new ArrayList<String>();
		test.add("a");
		
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		
		ss.next();
		ss.set("bbbb");
	}
	
	@Test
	public void testAdd() {
		test = new ArrayList<String>();
		test.add("a");
		
		ShortStrings ss = new ShortStrings(test.listIterator(), 2);
		
		ss.add("b");
		assertEquals("b", test.get(0));
	}

}
