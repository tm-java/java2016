package jpl.ch02.ex13;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class VehicleTest {

	@Test
	public void test() {

		//Speed
		Vehicle v1 = new Vehicle();
		v1.setSpeed(100);
		assertEquals(100,v1.getSpeed());
		v1.setSpeed(-1);
		assertEquals(100,v1.getSpeed());
		
		//Angle
		v1.setAngle(100);
		assertEquals(100, v1.getAngle());
		v1.setAngle(-100);
		assertEquals(260,v1.getAngle());
		
		//Owner
		v1.setOwner("test");
		assertEquals("test",v1.getOwner());
		
		//ID
		assertEquals(0,v1.getID());
		
		//Main
		String[] expected = new String[] {	"ID : 1 [100km/h, 10Cº, 0san]",
				"ID : 2 [101km/h, 11Cº, 1san]",
				"ID : 3 [102km/h, 12Cº, 2san]",
				"ID : 4 [103km/h, 13Cº, 3san]",
				"ID : 5 [104km/h, 14Cº, 4san]",
				"maxID : 5"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		Vehicle.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
		
	}

}
