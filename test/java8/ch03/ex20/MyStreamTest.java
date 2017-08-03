package java8.ch03.ex20;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MyStreamTest {

	@Test
	public void test() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		String[] expected = {"1", "2", "3", "4"};
		
		List<String> result = MyStream.map(list, t -> String.valueOf(t));
		assertTrue(Arrays.equals(expected, result.toArray()));
	}

}
