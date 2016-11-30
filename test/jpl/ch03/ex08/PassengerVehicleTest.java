package jpl.ch03.ex08;
import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class PassengerVehicleTest {
	

	@Test
	public void test() {
		
		//clone
		PassengerVehicle test = new PassengerVehicle("test",5,3);
		test.setSpeed(100);
		test.setAngle(90);
		try {
			PassengerVehicle cln = test.clone();
			assertEquals(test.getID(),cln.getID());
			assertEquals(test.getOwner(),cln.getOwner());
			assertEquals(test.getAngle(),cln.getAngle());
			assertEquals(test.getPassengers(),cln.getPassengers());
			assertEquals(test.getSheets(),cln.getSheets());
			assertEquals(test.getSpeed(),cln.getSpeed());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//main
		String[] expected = new String[] {"ID : 1, speed : 100, angle : 90, owner : p1, sheets : 5, passengers : 3",
		"ID : 1, speed : 100, angle : 90, owner : p1, sheets : 5, passengers : 3"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		PassengerVehicle.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
