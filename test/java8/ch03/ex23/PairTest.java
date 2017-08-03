package java8.ch03.ex23;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	@Test
	public void test() {
		Pair<Integer> in = new Pair<>(1, 2);
		Pair<String> out = in.map(t -> { return String.valueOf(t) + "!!";});
		assertEquals("1!!", out.getFirst());
		assertEquals("2!!", out.getSecond());
	}

}
