package jpl.ch04.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListCellImplTest {

	@Test
	public void testNew() {
		ListCell test = new ListCellImpl("test",null);
		assertNotNull(test);	
	}
	
	@Test
	public void testGet() {
		ListCell test = new ListCellImpl("test",null);
		assertEquals("test", test.get());
	}
	
	@Test
	public void testNext() {
		ListCell nxt = new ListCellImpl("nxt",null);
		ListCell test = new ListCellImpl("test",nxt);
		
		/*
		if(nxt == test.next()){
			System.out.println("equal");
			//実行したらこっちだった
		}
		else {
			System.out.println("not equal");
		}*/
		//assertEqualsは一体何を比較している？
		
		assertEquals(nxt,test.next());
	}
	
	@Test
	public void testSetNext() {
		ListCell nxt = new ListCellImpl("nxt",null);
		ListCell test = new ListCellImpl("test",null);
		assertEquals(null, test.next());
		test.setNext(nxt);
		assertEquals(nxt, test.next());
	}
	
	@Test
	public void testEquals() {
		ListCell otherT = new ListCellImpl("data",null);
		ListCell otherF = new ListCellImpl("no data",null);
		ListCell test = new ListCellImpl("data",null);
		assertEquals(true, test.equals(otherT));
		assertEquals(false, test.equals(otherF));
	}
	
	
	@Test
	public void testHashCode() {
		ListCell test = new ListCellImpl("test",null);
		//int expected = 31 + "test".hashCode();
		assertEquals("test".hashCode(), test.hashCode());
	}
	
	
	@Test
	public void testToString() {
		ListCell test = new ListCellImpl("test",null);
		assertEquals("test", test.toString());
	}
	
	

}
