package jpl.ch13.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringSarchTest {

	@Test
	public void test() {
		assertEquals(1,StringSarch.countSubString("abc", "abc"));
		assertEquals(2,StringSarch.countSubString("abceabc", "abc"));
		assertEquals(3,StringSarch.countSubString("aaaa", "aa"));
		assertEquals(0,StringSarch.countSubString("abc", "bcd"));
	}

}
