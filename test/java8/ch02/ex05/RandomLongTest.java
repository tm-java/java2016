package java8.ch02.ex05;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RandomLongTest {
	//乱数のテストは、100万個くらい作って、数値を分割して均等に数値が出てきたら、乱数になっていると判断できる
	@Test
	public void test1() {
		Long[] expected = {0L, 0L, 0L};
		Long[] result = RandomLong.generate(0, 1, 1, 1).limit(3).toArray(Long[]::new);
		assertTrue(Arrays.equals(expected, result));
		
	}
	
	@Test
	public void test2() {
		Long[] expected = {7L, 5L, 9L};
		Long[] result = RandomLong.generate(7, 8, 9, 10).limit(3).toArray(Long[]::new);
		assertTrue(Arrays.equals(expected, result));
		
	}

}
