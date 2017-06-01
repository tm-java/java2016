package jpl.ch20.ex10;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CountWordsTest {

	@Test
	public void test1() throws IOException {
		Reader reader = new StringReader("twinkle, twinkle, little star How I wonder what you are");
		
		HashMap<String, Integer> expected = new HashMap<String, Integer>();
		expected.put("twinkle", 2);
		expected.put("little", 1);
		expected.put("star", 1);
		expected.put("How", 1);
		expected.put("I", 1);
		expected.put("wonder", 1);
		expected.put("what", 1);
		expected.put("you", 1);
		expected.put("are", 1);
		
		HashMap<String, Integer> actual = CountWords.countWords(reader);
		assertEquals(expected.size(), actual.size());
		for (Map.Entry<String, Integer> entry : expected.entrySet()) {
			assertTrue(actual.containsKey(entry.getKey()));
			assertEquals(entry.getValue(), actual.get(entry.getKey()));
		}	
	}

}
