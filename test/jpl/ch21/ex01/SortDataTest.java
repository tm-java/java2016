package jpl.ch21.ex01;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SortDataTest {

	@Test
	public void test1() {
		String file1 = "test/jpl/ch21/ex01/input1.txt";
		List<String> expected = Arrays.asList("java", "language", "programming");
		List<String> actual = new LinkedList<String>();
		try {
			actual = SortData.sortData(file1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			assertTrue((expected.get(i)).equals(actual.get(i)));
		}

	}

	@Test
	public void test2() {
		String file2 = "test/jpl/ch21/ex01/input2.txt";
		List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
		List<String> actual = new LinkedList<String>();
		try {
			actual = SortData.sortData(file2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals(expected.size(), actual.size());
		for (int i = 0; i < expected.size(); i++) {
			assertTrue((expected.get(i)).equals(actual.get(i)));
		}


	}

}
