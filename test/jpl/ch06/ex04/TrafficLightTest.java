package jpl.ch06.ex04;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;



public class TrafficLightTest {

	@Test
	public void testRED() {
		assertEquals(Color.RED,TrafficLight.RED.getColor());
	}
	
	@Test
	public void testYELLOW() {
		assertEquals(Color.YELLOW ,TrafficLight.YELLOW.getColor());
	}
	
	@Test
	public void testGREEN() {
		assertEquals(Color.GREEN,TrafficLight.GREEN.getColor());
	}

}
