package java8.ch03.ex09;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class LexicongraphicComparatorTest {
	
	@Test
	public void test1() {
		Parson p1 = new Parson("taro", "java");
		Parson p2 = new Parson("hanako", "8");
		List<Parson> list = Arrays.asList(p1, p2);
		list.sort((Comparator<? super Parson>) LexicongraphicComparator.lexicongraphicComaparator("lastName", "firstName"));
		assertEquals("hanako", list.get(0).getFirstName());
	}

	@Test
	public void test2() {
		Parson p1 = new Parson("taro", "java");
		Parson p2 = new Parson("hanako", "java");
		List<Parson> list = Arrays.asList(p1, p2);
		list.sort((Comparator<? super Parson>) LexicongraphicComparator.lexicongraphicComaparator("lastName", "firstName"));
		assertEquals("hanako", list.get(0).getFirstName());
	}
	
	@Test
	public void test3() {
		Parson p1 = new Parson("hanako", "java");
		Parson p2 = new Parson("hanako", "java");
		List<Parson> list = Arrays.asList(p1, p2);
		list.sort((Comparator<? super Parson>) LexicongraphicComparator.lexicongraphicComaparator("lastName", "firstName"));
		assertEquals("hanako", list.get(0).getFirstName());
	}

}
