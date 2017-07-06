package java8.ch02.ex07;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class FiniteTest {
	//結果出るまで13秒かかります
	@Test
	public void test1() {
		Stream<String> stream = Stream.generate(() -> "（＾ω＾）（’∀’）");
		assertFalse(Finite.isFinite(stream));
	}
	
	@Test
	public void test2() {
		Stream<String> stream = Stream.generate(() -> "（＾ω＾）（’∀’）").limit(10);
		assertTrue(Finite.isFinite(stream));
	}

}
