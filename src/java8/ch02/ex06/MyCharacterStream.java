package java8.ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyCharacterStream {
	public static Stream<Character> CharacterStream(String s) {
		Stream<Integer> istream = Stream.iterate(0, i -> i + 1).limit(s.length());
		return istream.map(s::charAt);
	}

}
