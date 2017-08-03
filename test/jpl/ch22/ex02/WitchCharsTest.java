package jpl.ch22.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class WitchCharsTest {

	@Test
	public void test() {
		String test = "Testing 1 2 3";
		String expected = "[ 123Teginst]";

		WitchChars wc = new WitchChars(test);			
		String actual = wc.toString();
		assertEquals(expected, actual);
		
	}

}
