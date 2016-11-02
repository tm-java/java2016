package jpl.ch02.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void test() {
		Vehicle v = new Vehicle();
		assertNotNull(v);
	}

}
