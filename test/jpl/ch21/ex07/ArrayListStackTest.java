package jpl.ch21.ex07;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class ArrayListStackTest {
	ArrayListStack<String> test = new ArrayListStack<String>();
	
	@Test
	public void testPushPeek() {
		test.push("0");
		assertEquals("0", test.peek());
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPeek() {
		test.peek();
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPop1() {
		test.pop();
	}
	
	@Test
	public void testPop2() {
		test.push("0");
		test.push("1");
		assertEquals("1", test.pop());
		assertEquals("0", test.pop());
		assertTrue(test.empty());
	}
	
	@Test
	public void testEmpty1() {
		assertTrue(test.empty());
	}
	
	@Test
	public void testEmpty2() {
		test.push("0");
		assertFalse(test.empty());
	}
	
	@Test
	public void testSerch() {
		test.push("0");
		test.push("1");
		assertEquals(2, test.search("0"));
		assertEquals(1, test.search("1"));
		assertEquals(-1, test.search("3"));
	}
	
	
	

}
