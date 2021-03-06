package jpl.ch13.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertCommaTest {

	@Test
	public void test1() {
		String testStr = "1543729";
		String expected = "1,543,729";
		String actual = InsertComma.insertComma(testStr);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void test2() {
		String testStr = "15";
		String expected = "15";
		String actual = InsertComma.insertComma(testStr);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void test3() {
		String testStr = "123";
		String expected = "123";
		String actual = InsertComma.insertComma(testStr);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void test4() {
		String testStr = "123456";
		String expected = "123,456";
		String actual = InsertComma.insertComma(testStr);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void test5() {
		String testStr = "";
		String expected = "";
		String actual = InsertComma.insertComma(testStr);
		
		assertEquals(expected,actual);
	}
	
	

}
