package java8.ch02.ex04;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyIntStream {
	public static void main(String[] args) {
		int[] values = {1, 4, 9, 16};
		
		//Stram.of(value)は、Stream<int[]>
		Stream<int[]> is = Stream.of(values);
		
		//intのストリーム
		IntStream stream = Arrays.stream(values);
		int[] result = stream.toArray();
		for (int i : result) {
			System.out.println(i);
		}
	}

}
