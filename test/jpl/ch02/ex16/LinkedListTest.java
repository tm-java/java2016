package jpl.ch02.ex16;

import static org.junit.Assert.*;

import org.junit.Test;

import jpl.ch02.ex13.Vehicle;

public class LinkedListTest {

	//size
	@Test
	public void testSize() {
		//先頭番地を示すヘッダー
		LinkedList head = new LinkedList();
		//Vehicleの配列
		Vehicle[] vcls = new Vehicle[Vehicle.FIVE];
				
		for(int i=0;i<Vehicle.FIVE;i++){
			//Vehicle型のデータ作成
			Vehicle v = new Vehicle("Mr."+i);
			v.setSpeed(100*i);
			v.setAngle(10*i);
					
			vcls[i] = v;
		}
		//配列をリスト構造にする
		head.makeList(head,vcls[0],vcls[1],vcls[2],vcls[3],vcls[4]);
				
		//サイズの確認
		assertEquals(Vehicle.FIVE,head.getNext().size());
		
	}

}
