package jpl.ch02.ex18;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class VehicleTest {

	@Test
	public void testMain() {
		String[] expected = new String[] {	"ID : 0, speed : 100, angle : 90, owner : Mr.18"};
		
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		Vehicle.main(new String[]{"Mr.18"});

		sc.stop();
		sc.assertEquals(expected);
	}

}
