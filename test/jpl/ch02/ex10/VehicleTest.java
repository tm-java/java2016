package jpl.ch02.ex10;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class VehicleTest {

	
	//Main
	@Test
	public void test() {
		//toString
		String s = "test_owner";
		int test_speed = 1;
		int test_angle = 2;
		String expected = "ID : 0, speed : "+test_speed+", angle : "+test_angle+", owner : "+s;
		Vehicle v = new Vehicle("test_owner");
		v.speed = test_speed;
		v.angle = test_angle;
		assertEquals(expected,v.toString());
		
		//main
		String[] expectedMain = new String[] {	"ID : 1, speed : 100, angle : 10, owner : 0san",
				"ID : 2, speed : 101, angle : 11, owner : 1san",
				"ID : 3, speed : 102, angle : 12, owner : 2san",
				"ID : 4, speed : 103, angle : 13, owner : 3san",
				"ID : 5, speed : 104, angle : 14, owner : 4san",
				"maxID : 5"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		Vehicle.main(new String[0]);

		sc.stop();
		sc.assertEquals(expectedMain);
		
	}
}
