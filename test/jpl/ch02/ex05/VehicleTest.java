package jpl.ch02.ex05;

import static org.junit.Assert.*;
import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testMain() {
		String[] expected = new String[] {	"ID : 0 [100km/h, 10Cº, 0san]",
											"ID : 1 [101km/h, 11Cº, 1san]",
											"ID : 2 [102km/h, 12Cº, 2san]",
											"ID : 3 [103km/h, 13Cº, 3san]",
											"ID : 4 [104km/h, 14Cº, 4san]"};
        
        StdoutCapture sc = new StdoutCapture();
        sc.start();
        
        Vehicle.main(new String[0]);
        
        sc.stop();
        sc.assertEquals(expected);
 
	}

}
