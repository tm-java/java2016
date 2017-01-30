package jpl.ch13.ex06;
import static org.junit.Assert.*;

import org.junit.Test;


public class InsertCharTest {

	@Test
	public void test1() {
		String testStr = "1543729";
		String expected = "1,543,729";
		String actual = InsertChar.insertChar(testStr,',',3);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void test2() {
		String testStr = "1543729";
		String expected = "1*54*37*29";
		String actual = InsertChar.insertChar(testStr,'*',2);
		
		assertEquals(expected,actual);
	}
	
	@Test
	public void test3() {
		String testStr = "1543729";
		String expected = "1543729";
		String actual = InsertChar.insertChar(testStr,'*',-2);
		
		assertEquals(expected,actual);
	}

}
