package jpl.ch03.ex12;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class PointTest {

	//引数なしコンストラクタ
	@Test
	public void testNew() {
		Point test = new Point();
		assertNotNull(test);
	}

	//引数ありコンストラクタ
	@Test
	public void testNew2() {
		Point test = new Point(1,1);
		assertEquals(1,test.getX());
		assertEquals(1,test.getY());
	}
			
	//x
	@Test
	public void testX() {
		Point test = new Point();
		test.setX(1);
		assertEquals(1,test.getX());
	}
	
	//y
	@Test
	public void testY() {
		Point test = new Point();
		test.setY(1);
		assertEquals(1,test.getY());
	}
	
	//moveTo(int x, int y)
	@Test
	public void testMoveTo() {
		Point test = new Point();
		assertEquals(0,test.getX());
		assertEquals(0,test.getY());
		
		test.moveTo(1, 1);
		assertEquals(1,test.getX());
		assertEquals(1,test.getY());	
	}
	
	//distance(Point p)
	@Test
	public void testDistance() {
		Point test = new Point(3,4);
		Point origin = new Point();
		assertEquals(5,origin.distance(test),0.0);
		//メモ
		//assertEquals(double,double,double)
		//3つ目の引数には、比較する時に許容する誤差を指定する
	}
	
	//compareTo(Point p)
	@Test
	public void testCompareTo() {
		Point test = new Point(3,4);
		Point origin = new Point();
		assertEquals(1,test.compareTo(origin));
		assertEquals(0,test.compareTo(test));
		assertEquals(-1,origin.compareTo(test));
	}
	//main
	@Test
	public void testMain() {
		String[] expected = new String[] {
				"(5, 5)",
				"(4, 4)",
				"(3, 3)",
				"(2, 2)",
				"(1, 1)",
				"(1, 1)",
				"(2, 2)",
				"(3, 3)",
				"(4, 4)",
				"(5, 5)"
		};

		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		Point.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
	}
}
