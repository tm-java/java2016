package java8.ch01.ex01;

import java.util.Arrays;

public class ArraysSort {
	
	public static void main(String[] args) {
		System.out.println("sort start @" + Thread.currentThread().getName());
		String[] strings = {"a","abs","defgjt","b"};
		Arrays.sort(strings, (first, second) -> {
			System.out.println("compare @" + Thread.currentThread().getName());
			return Integer.compare(first.length(), second.length());
			});
	}

}
