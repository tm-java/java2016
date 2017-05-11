package jpl.ch22.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

public class WitchCharsTest {

	@Test
	public void test() {
		String test = "Testing 1 2 3 アイウエオ";
		String expected = "[ 123Teginstアイウエオ]";

		WitchChars wc = new WitchChars(test);			
		String actual = wc.toString();
		assertEquals(expected, actual);
		
	}

}
