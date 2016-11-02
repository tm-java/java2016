package jpl.ch02.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class VehicleTest {

	
	@Test
	public void test() {
		
		//コンストラクタ
		Vehicle v =  new Vehicle();
		assertNotNull(v);
		
		//引数ありコンストラクタ
		String s = "test";
		Vehicle v2 = new Vehicle(s);
		assertEquals(s,v2.owner);
		
		//IDの最大値を更新するメソッド
		Vehicle v3 = new Vehicle();
		v3.UpMaxID();
		assertEquals(Vehicle.nextID,Vehicle.maxID);
		
		//IDの最大値を取得するメソッド
		assertEquals(Vehicle.maxID,Vehicle.getMaxID());
		
		
		//Main
		String[] expected = new String[] {	"ID : 3 [100km/h, 10Cº, 0san]",
				"ID : 4 [101km/h, 11Cº, 1san]",
				"ID : 5 [102km/h, 12Cº, 2san]",
				"ID : 6 [103km/h, 13Cº, 3san]",
				"ID : 7 [104km/h, 14Cº, 4san]",
				"maxID : 7"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		Vehicle.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
		
		
	}

}
