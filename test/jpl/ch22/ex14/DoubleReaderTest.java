package jpl.ch22.ex14;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleReaderTest {

	@Test
	public void test() {
		String input = "1.5 2.7 8.3";
		double expected = 12.5;
		double actual = DoubleReader.sumDouble(input);
		assertTrue(expected - actual < 0.0000001);
	}

}
