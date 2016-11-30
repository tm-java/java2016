package jpl.ch03.ex12;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortHarnessTest {

	static final int MAX =5;
	
	@Test
	public void testSortInt() {
		Integer[] testInt = new Integer[MAX];
		//代入 
		for(int i=0;i<MAX;i++){
			testInt[i]=MAX-1-i;
		}
		//確認
		for(int i=0;i<MAX;i++){
			assertEquals(MAX-1-i,(int)testInt[i]);
		}
		
		//sort
		SortHarness.sort(testInt);
		//確認
		for(int i=0;i<MAX;i++){
			assertEquals(i,(int)testInt[i]);
		}
		
	}
	
	
	@Test
	public void testSortString() {
		String[] testString = {"e","b","d","a","c"};
		
		//sort
		SortHarness.sort(testString);
		//確認
		assertEquals("a",testString[0]);
		assertEquals("b",testString[1]);
		assertEquals("c",testString[2]);
		assertEquals("d",testString[3]);
		assertEquals("e",testString[4]);
	}

}
