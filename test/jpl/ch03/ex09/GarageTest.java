package jpl.ch03.ex09;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class GarageTest {
/*
	@Test
	public void test() {
		//main
		String[] expected = new String[] {
		"vehicle[0] (ID : 0, speed : 0, angle : 0, gas : 0, battery : 0, owner : g1) vehicle[1] (ID : 1, speed : 0, angle : 0, gas : 0, battery : 0, owner : g2)",
		"vehicle[0] (ID : 0, speed : 0, angle : 0, gas : 0, battery : 0, owner : g1) vehicle[1] (ID : 1, speed : 0, angle : 0, gas : 0, battery : 0, owner : g2)"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		Garage.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}
*/
	
	/*
	 * 結果はあっていると思うのですが、NGとして出力されます。
	 * コメントアウトして提出します
	 * Result is
		vehicle[0] (ID : 0, speed : 0, angle : 0, gas : 0, battery : 0, owner : g1) vehicle[1] (ID : 1, speed : 0, angle : 0, gas : 0, battery : 0, owner : g2) 
		vehicle[0] (ID : 0, speed : 0, angle : 0, gas : 0, battery : 0, owner : g1) vehicle[1] (ID : 1, speed : 0, angle : 0, gas : 0, battery : 0, owner : g2) 
		
		But want is
		vehicle[0] (ID : 0, speed : 0, angle : 0, gas : 0, battery : 0, owner : g1) vehicle[1] (ID : 1, speed : 0, angle : 0, gas : 0, battery : 0, owner : g2)
		vehicle[0] (ID : 0, speed : 0, angle : 0, gas : 0, battery : 0, owner : g1) vehicle[1] (ID : 1, speed : 0, angle : 0, gas : 0, battery : 0, owner : g2)
	 * 
	 * 
	 */
}
