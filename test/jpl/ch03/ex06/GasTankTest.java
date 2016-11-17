package jpl.ch03.ex06;

import static org.junit.Assert.*;

import org.junit.Test;

public class GasTankTest {

	//引数なしコンストラクタ
	@Test
	public void testNew() {
		GasTank g = new GasTank();
		assertNotNull(g);
	}
	
	//引数ありコンストラクタ
	@Test
	public void testNew2() {
		GasTank g = new GasTank(50);
		assertNotNull(g);
	}
	
	//gas
	@Test
	public void testGas() {
		GasTank g = new GasTank();
		g.setGas(50);
		assertEquals(50,g.getGas());
		
		g.setGas(-1);
		assertEquals(0,g.getGas());
		
		g.setGas(101);
		assertEquals(100,g.getGas());
	}
	
	@Test
	public void testEmpty(){
		GasTank g = new GasTank();
		g.setGas(50);
		assertEquals(false,g.empty());
		
		g.setGas(0);
		assertEquals(true,g.empty());
	}

}
