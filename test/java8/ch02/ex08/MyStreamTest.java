package java8.ch02.ex08;

import static org.junit.Assert.*;

import java.util.stream.Stream;

import org.junit.Test;

public class MyStreamTest {

	@Test
	public void test() {
		Stream<Integer> first = Stream.iterate(0, i -> i + 2).limit(5);
		Stream<Integer> second = Stream.iterate(1, i -> i + 2).limit(2);
		
		MyStream.zip(first, second).forEach(System.out::println);
		
	}

}
