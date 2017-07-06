package java8.ch02.ex09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MyStream2Test {

	@Test
	public void test1() {
		Integer[] expected = { 0, 1, 1, 2, 4, 5};
		
		List<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> l = new ArrayList<>();
			l.add(i*i);l.add(i*i+1);
			list.add(l);
		}
		
		assertTrue(Arrays.equals(expected, MyStream2.toArrayList1(list.stream()).toArray()));

	}

	@Test
	public void test2() {
		Integer[] expected = { 0, 1, 1, 2, 4, 5};
		
		List<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> l = new ArrayList<>();
			l.add(i*i);l.add(i*i+1);
			list.add(l);
		}
		
		assertTrue(Arrays.equals(expected, MyStream2.toArrayList2(list.stream()).toArray()));

	}
	
	@Test
	public void test3() {
		Integer[] expected = { 0, 1, 1, 2, 4, 5};
		
		List<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			ArrayList<Integer> l = new ArrayList<>();
			l.add(i*i);l.add(i*i+1);
			list.add(l);
		}
		
		assertTrue(Arrays.equals(expected, MyStream2.toArrayList3(list.stream()).toArray()));

	}

}
