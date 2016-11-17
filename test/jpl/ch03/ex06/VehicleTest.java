package jpl.ch03.ex06;

import static org.junit.Assert.*;

import org.junit.Test;
import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class VehicleTest {

	//新しく追加したコンストラクタ
	@Test
	public void testNew() {
		Vehicle v = new Vehicle("test",100,100);
		assertNotNull(v);
	}
	
	@Test
	public void testStart() {
		Vehicle v1 = new Vehicle("test1",100,100);
		assertEquals(true,v1.start());
		
		Vehicle v2 = new Vehicle("test2");
		assertEquals(false,v2.start());
	}
	
	@Test
	public void testMain() {
		String[] expected = new String[] {"ex36OK start : true",
				"ex36NG start : false"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		Vehicle.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}
