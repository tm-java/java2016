package jpl.ch04.ex01;

import static org.junit.Assert.*;

import org.junit.Test;


public class BatteryTest {

	//引数なしコンストラクタ
	@Test
	public void testNew() {
		Battery b = new Battery();
		assertNotNull(b);
	}
	
	//引数ありコンストラクタ
	@Test
	public void testNew2() {
		Battery b = new Battery(100);
		assertNotNull(b);
	}
	
	
	//セッターゲッター
	@Test
	public void testBattery() {
		Battery b = new Battery();
		b.setBattery(50);
		assertEquals(50,b.getBattery());
		
		b.setBattery(-1);
		assertEquals(0,b.getBattery());
		
		b.setBattery(101);
		assertEquals(100,b.getBattery());
	}
	
	@Test
	public void testEmpty(){
		Battery b = new Battery();
		b.setBattery(50);
		assertEquals(false,b.empty());
		
		b.setBattery(0);
		assertEquals(true,b.empty());
	}


}
