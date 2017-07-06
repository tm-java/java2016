package java8.ch02.ex06;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MyCharacterStreamTest {

	@Test
	public void test() {
		Character[] expected = {'b', 'o', 'a', 't'};
		Character[] result = MyCharacterStream.CharacterStream("boat").toArray(Character[]::new);
		assertTrue(Arrays.equals(expected, result));
	}

}
