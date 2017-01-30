package jpl.ch13.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class DelimitedStringTest {

	@Test
	public void test1() {
		String[] expected = new String[]{"<a>" , "<a>,<b>" , "<b>"};
		
		String[] actual = DelimitedString.delimitedString("<a>,<b>",'<','>');
		
		assertEquals(expected.length,actual.length);
		
		for(int i=0;i<expected.length;i++){
			assertEquals(expected[i],actual[i]);
			
		}
	}
	
	@Test
	public void test2() {
		String[] expected = new String[]{"<a<" , "<" };
		
		String[] actual = DelimitedString.delimitedString("<a<",'<','>');
		
		assertEquals(expected.length,actual.length);
		
		for(int i=0;i<expected.length;i++){
			assertEquals(expected[i],actual[i]);
			
		}
	}
	
	@Test
	public void test3() {
		String[] actual = DelimitedString.delimitedString("a",'<','>');
		
		assertNull(actual);
		

	}

}
