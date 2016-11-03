package jpl.ch02.ex17;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class VehicleTest {

	@Test
	public void test() {
		//Main
		String[] expected = new String[] {	"Mr.17's angle is 90",
				"turn +30º  -->> 120",
				"turn -90º  -->> 30",
				"turn left  -->> 300",
				"turn right  -->> 30"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		Vehicle.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}
