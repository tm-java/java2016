package java8.ch04.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.beans.property.LongProperty;
import javafx.beans.property.StringProperty;

public class StaffTest {

	@Test
	public void test1() {
		Staff s = new Staff("Tom");
		assertEquals("Tom", s.getName());
		assertEquals(0, s.getId());
	}
	
	@Test
	public void test2() {
		Staff s = new Staff("Tom");
		s.setName("Tim");
		assertEquals("Tim", s.getName());
	}
	
	@Test
	public void test3() {
		Staff s = new Staff("Tom");
		s.setId(1000);
		assertEquals(1000, s.getId());
	}
	
	@Test
	public void test4() {
		Staff s = new Staff("Tom");
		StringProperty sp = s.getNameProperty();
		assertEquals("Tom", s.getName());
		assertEquals("Tom", sp.get());
		s.setName("Tim");
		assertEquals("Tim", s.getName());
		assertEquals("Tim", sp.get());
	}
	

	@Test
	public void test5() {
		Staff s = new Staff("Tom");
		LongProperty lp = s.getIdProperty();
		assertEquals(4, s.getId());
		assertEquals(4, lp.get());
		s.setId(100);
		assertEquals(100, s.getId());
		assertEquals(100, lp.get());
	}
	
	

}
