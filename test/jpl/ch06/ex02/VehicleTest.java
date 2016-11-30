package jpl.ch06.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

import jpl.ch06.ex02.Vehicle.Direction;

public class VehicleTest {

	@Test
	public void testTurn() {
		Vehicle test = new Vehicle();
		test.setAngle(180);
		test.turn(Direction.TURN_LEFT);
		assertEquals(90,test.getAngle());
		test.turn(Direction.TURN_RIGHT);
		assertEquals(180,test.getAngle());
		
	}

}
