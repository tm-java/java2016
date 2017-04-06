package jpl.ch20.ex04;

import static org.junit.Assert.*;

import java.io.FilterReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

public class LineFilterReaderTest {

	@Test
	public void test() {
		String input = "aaaa\nbbb\ncc\nd";
		String[] expected = { "aaaa", "bbb", "cc", "d" };

		StringReader sr = new StringReader(input);
		LineFilterReader lfr = new LineFilterReader(sr);
		String s;
		int i = 0;
		try {
			while ((s = lfr.readLine()) != null) {
				assertEquals(s, expected[i]);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
