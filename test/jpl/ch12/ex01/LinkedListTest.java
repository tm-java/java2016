package jpl.ch12.ex01;

import static org.junit.Assert.*;

import org.junit.Test;



public class LinkedListTest {
	
	@Test
	public void test() {
		LinkedList<Integer> header = new LinkedList<Integer>();
		for(int i=0;i<10;i++){
			LinkedList<Integer> cell = new LinkedList<Integer>(i,header.getNext());
			header.setNext(cell);
		}
		
		try {
			header.find(1);
		} catch (ObjectNotFoundException e) {
			fail();
		}
		
	}
	
	@Test
	public void test2() {
		LinkedList<Integer> header = new LinkedList<Integer>();
		for(int i=0;i<10;i++){
			LinkedList<Integer> cell = new LinkedList<Integer>(i,header.getNext());
			header.setNext(cell);
		}
		
		
		try {
			header.find(11);
			fail();
		} catch (ObjectNotFoundException e) {
			assertTrue(true);
		}
		
		
	}

}
