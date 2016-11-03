package jpl.ch02.ex15;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class VehicleTest {

	@Test
	public void test() {
		Vehicle v = new Vehicle();
		v.setSpeed(100);
		
		//chenageSpeed
		v.changeSpeed(200);
		assertEquals(200,v.getSpeed());
		
		//stop
		v.stop();
		assertEquals(0,v.getSpeed());
		
		//Main
		String[] expected = new String[] {	"ID : 1 [100km/h, 10Cº, 0san]",
				"v speed change",
				"ID : 1, speed : 200, angle : 10, owner : 0san",
				"v stop",
				"ID : 1, speed : 0, angle : 10, owner : 0san"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		Vehicle.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}
