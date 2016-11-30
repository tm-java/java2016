package jpl.ch04.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListImplTest {

	@Test
	public void testNew() {
		LinkedList test = new LinkedListImpl();
		assertNotNull(test);
	}
	
	@Test
	public void testSize() {
		LinkedList test = new LinkedListImpl();
		assertEquals(0,test.size());
	}
	

	@Test
	public void testRemove() {
		LinkedList test = new LinkedListImpl();
		test.add("added");
		assertEquals(1,test.size());
		test.remove("added");
		assertEquals(0,test.size());
	}
	
	@Test
	public void testAdd() {
		LinkedList test = new LinkedListImpl();
		test.add("added");
		assertEquals(1,test.size());
	}

}
