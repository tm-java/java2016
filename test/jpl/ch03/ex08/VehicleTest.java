package jpl.ch03.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class VehicleTest {

	@Test
	public void test() {
		//clone
		Vehicle test = new Vehicle("test",50,100);

		try {
			Vehicle cln = test.clone();
			assertEquals(test.getID(),cln.getID());
			assertEquals(test.getOwner(),cln.getOwner());
			assertEquals(test.getAngle(),cln.getAngle());
			assertEquals(((GasTank)test.gasTank).getGas(),((GasTank)cln.gasTank).getGas());
			assertEquals(((Battery)test.battery).getBattery(),((Battery)cln.battery).getBattery());
			assertEquals(test.getSpeed(),cln.getSpeed());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//main
		String[] expected = new String[] {"ID : 1, speed : 0, angle : 0, gas : 50, battery : 100, owner : v",
		"ID : 1, speed : 0, angle : 0, gas : 50, battery : 100, owner : v"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		Vehicle.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
