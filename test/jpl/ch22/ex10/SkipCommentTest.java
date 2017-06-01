package jpl.ch22.ex10;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SkipCommentTest {

	@Test
	public void test() throws IOException {
		String input = "abc\n#comment\ndef\n#this is comment\nghi\n";
		String[] expected = { "abc", "def", "ghi" };

		StringReader sr = new StringReader(input);
		List<String> actual;

		actual = SkipComment.skipComment(sr);
		for (String s : actual) {
			System.out.println(s);
		}
		assertTrue(Arrays.equals(expected, actual.toArray()));
	}

}
