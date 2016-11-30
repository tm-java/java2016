package jpl.ch06.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrafficLightTest {

	@Test
	public void test() {
		TrafficLight[] tl = TrafficLight.values();
		assertEquals("RED",tl[0].name());
		assertEquals("YELLOW",tl[1].name());
		assertEquals("GREEN", tl[2].name());
	}

}
