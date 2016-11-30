package jpl.ch06.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeekTest {

	@Test
	public void test() {
		Week[] week = Week.values();
		assertEquals("MONDAY",week[0].name());
		assertEquals("TUSEDAY",week[1].name());
		assertEquals("WEDNESDAY",week[2].name());
		assertEquals("THURSDAY",week[3].name());
		assertEquals("FRIDAY",week[4].name());
		assertEquals("SATURDAY",week[5].name());
		assertEquals("SUNDAY",week[6].name());
		
	}

}
