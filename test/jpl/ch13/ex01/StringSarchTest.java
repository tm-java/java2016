package jpl.ch13.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringSarchTest {

	@Test
	public void test() {
		assertEquals(1,StringSarch.countChar("abc", 'a'));
		assertEquals(5,StringSarch.countChar("aaaaa", 'a'));
		assertEquals(0,StringSarch.countChar("abc", 'd'));
		//2017.3.3空文字列を入れた時のテストも
	}

}
