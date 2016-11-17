package jpl.ch03.ex01;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class PassengerVehicleTest {

	@Test
	public void test() {
		//引数なしコンストラクタ
		PassengerVehicle test0 = new PassengerVehicle();
		assertNotNull(test0);
		
		//引数owner,sheetsコンストラクタ
		String name = "test1";
		int sheets = 5;
		PassengerVehicle test1 = new PassengerVehicle(name,sheets);
		assertEquals(name,test1.getOwner());
		assertEquals(sheets,test1.getSheets());
		
		//引数owner,sheets,passengersコンストラクタ
		name = "test2";
		sheets = 5;
		int passengers = 2;
		PassengerVehicle test2 = new PassengerVehicle(name,sheets,passengers);
		assertEquals(name,test2.getOwner());
		assertEquals(sheets,test2.getSheets());
		assertEquals(passengers,test2.getPassengers());
		
		//setPassengers
		test2.setPassengers(-1);//負の数をセット
		assertEquals(0,test2.getPassengers());//期待値0
		test2.setPassengers(sheets+1);//座席数以上の数をセット
		assertEquals(sheets,test2.getPassengers());//期待値座席数
		test2.setPassengers(sheets-1);//座席数−１の値をセット
		assertEquals(sheets-1,test2.getPassengers());//期待値座席数−１
			
		//setSheets
		test2.setSheets(-1);//負の値をセット
		assertEquals(0,test2.getSheets());//期待値0
		assertEquals(0,test2.getPassengers());//期待値座席数の変更に応じて座っている人数も0
	
		//main
		String[] expected = new String[] {	"ID : 3, speed : 100, angle : 90, owner : p1, sheets : 5, passengers : 3",
				"ID : 4, speed : 200, angle : 180, owner : p2, sheets : 2, passengers : 2"};
		
		StdoutCapture sc = new StdoutCapture();
		sc.start();

		PassengerVehicle.main(new String[0]);

		sc.stop();
		sc.assertEquals(expected);
	}

}
