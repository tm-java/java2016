package java8.ch03.ex07;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MyComparatorTest {
	private String s0 = "abcdefg";
	private String s1 = "abc def g";
	private String s2 = "Abcdefg";
	private String s3 = "Abc def g";
	private String s4 = "gfedcba";
	private String[] input = { s2, s3, s0, s4, s1 };

	@Test
	public void test1() {
		List<String> test = Arrays.asList(input);
		String[] expected = { s2, s3, s0, s1, s4};
		test.sort(MyComparator.stringComparator(true, false, false));
		System.out.println("1");
		test.stream().forEach(System.out::println);
		assertTrue(Arrays.equals(expected, test.toArray()));
	}
	
	@Test
	public void test2() {
		List<String> test = Arrays.asList(input);
		String[] expected = { s4, s2, s3, s0, s1};
		test.sort(MyComparator.stringComparator(false, false, false));
		System.out.println("2");
		test.stream().forEach(System.out::println);
		assertTrue(Arrays.equals(expected, test.toArray()));
	}
	
	@Test
	public void test3() {
		List<String> test = Arrays.asList(input);
		String[] expected = { s2, s3, s0, s1, s4};
		test.sort(MyComparator.stringComparator(true, true, false));
		System.out.println("3");
		test.stream().forEach(System.out::println);
		assertTrue(Arrays.equals(expected, test.toArray()));
	}
	
	@Test
	public void test4() {
		List<String> test = Arrays.asList(input);
		String[] expected = { s4, s0, s1, s2, s3};
		test.sort(MyComparator.stringComparator(false, true, false));
		System.out.println("4");
		test.stream().forEach(System.out::println);
		assertTrue(Arrays.equals(expected, test.toArray()));
	}
	
	@Test
	public void test5() {
		List<String> test = Arrays.asList(input);
		String[] expected = { s3, s2, s1, s0, s4};
		test.sort(MyComparator.stringComparator(true, true, true));
		System.out.println("5");
		test.stream().forEach(System.out::println);
		assertTrue(Arrays.equals(expected, test.toArray()));
	}
	
	@Test
	public void test6() {
		List<String> test = Arrays.asList(input);
		String[] expected = { s4, s0, s1, s2, s3};
		test.sort(MyComparator.stringComparator(false, true, true));
		System.out.println("6");
		test.stream().forEach(System.out::println);
		assertTrue(Arrays.equals(expected, test.toArray()));
	}
	
	@Test
	public void test7() {
		List<String> test = Arrays.asList(input);
		String[] expected = { s3, s1, s2, s0, s4};
		test.sort(MyComparator.stringComparator(true, false, true));
		System.out.println("7");
		test.stream().forEach(System.out::println);
		assertTrue(Arrays.equals(expected, test.toArray()));
	}
	
	@Test
	public void test8() {
		List<String> test = Arrays.asList(input);
		String[] expected = { s4, s2, s0, s3, s1};
		test.sort(MyComparator.stringComparator(false, false, true));
		System.out.println("8");
		test.stream().forEach(System.out::println);
		assertTrue(Arrays.equals(expected, test.toArray()));
	}

}
