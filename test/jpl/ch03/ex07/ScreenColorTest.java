package jpl.ch03.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScreenColorTest {

	//Screen()
	@Test
	public void testNew() {
		ScreenColor test = new ScreenColor();
		assertNotNull(test);
	}
	
	//ScreenColor(int r,int g,int b)
	@Test
	public void testNew2() {
		ScreenColor test = new ScreenColor(0,0,0);
		Integer zero = 0;
		assertEquals(zero,test.getR());
		assertEquals(zero,test.getG());
		assertEquals(zero,test.getB());
	}
	
	//ScreenColor(Object value)
	@Test
	public void testNew3() {
		Object red = "red";
		Object green = "green";
		Object blue = "blue";
		Object white = "white";
		Object transparent = "transparent";
		ScreenColor testR = new ScreenColor(red);
		ScreenColor testG = new ScreenColor(green);
		ScreenColor testB = new ScreenColor(blue);
		ScreenColor testW = new ScreenColor(white);
		ScreenColor testT = new ScreenColor(transparent);
		
		Integer zero = 0;
		Integer max = 255;
		assertEquals(max,testR.getR());assertEquals(zero,testR.getG());assertEquals(zero,testR.getB());
		assertEquals(zero,testG.getR());assertEquals(max,testG.getG());assertEquals(zero,testG.getB());
		assertEquals(zero,testB.getR());assertEquals(zero,testB.getG());assertEquals(max,testB.getB());
		assertEquals(max,testW.getR());assertEquals(max,testW.getG());assertEquals(max,testW.getB());
		assertNull(testT.getR());assertNull(testT.getG());assertNull(testT.getB());

		
	}
	
	//R
	@Test
	public void testR() {
		ScreenColor test = new ScreenColor();
		Integer minus = -1;
		Integer zero = 0;
		Integer max = 255;
		Integer over = 300;
		
		test.setR((int)minus);
		assertEquals(zero,test.getR());
		
		test.setR((int)zero);
		assertEquals(zero,test.getR());
		
		test.setR((int)max);
		assertEquals(max,test.getR());
		
		test.setR((int)over);
		assertEquals(max,test.getR());
	}
	
	//G
	@Test
	public void testG() {
		ScreenColor test = new ScreenColor();
		Integer minus = -1;
		Integer zero = 0;
		Integer max = 255;
		Integer over = 300;
		
		test.setG((int)minus);
		assertEquals(zero,test.getG());
		
		test.setG((int)zero);
		assertEquals(zero,test.getG());
		
		test.setG((int)max);
		assertEquals(max,test.getG());
		
		test.setG((int)over);
		assertEquals(max,test.getG());
	}
	
	//B
	@Test
	public void testB() {
		ScreenColor test = new ScreenColor();
		Integer minus = -1;
		Integer zero = 0;
		Integer max = 255;
		Integer over = 300;
		
		test.setB((int)minus);
		assertEquals(zero,test.getB());
		
		test.setB((int)zero);
		assertEquals(zero,test.getB());
		
		test.setB((int)max);
		assertEquals(max,test.getB());
		
		test.setB((int)over);
		assertEquals(max,test.getB());
	}
	
	
	
	//toString()
	@Test
	public void testToString() {
		ScreenColor testR = new ScreenColor("red");
		ScreenColor testG = new ScreenColor("green");
		ScreenColor testB = new ScreenColor("blue");
		ScreenColor testW = new ScreenColor("white");
		ScreenColor testT = new ScreenColor("transparent");
		
		assertEquals("red",testR.toString());
		assertEquals("green",testG.toString());
		assertEquals("blue",testB.toString());
		assertEquals("white",testW.toString());
		assertEquals("r : null, g : null, b : null",testT.toString());
		
	}
	
	//boolean equals(Object obj)
	@Test
	public void testEquals() {
		ScreenColor test = new ScreenColor();
		ScreenColor test2 = new ScreenColor(0,0,0);
	
		assertEquals(true,test.equals(test));
		assertEquals(false,test.equals(null));
		assertEquals(false,test.equals(new Object()));
		
		//r=null other.r!=null
		assertEquals(false,test.equals(test2));
		
		//r=1 other.r=0
		test.setR(1);
		assertEquals(false,test.equals(test2));
		
		//g=null other.g!=null
		test.setR(0);
		assertEquals(false,test.equals(test2));
		
		//g=1 other.g = 0
		test.setG(1);
		assertEquals(false,test.equals(test2));
		
		//b=null other.b!=null
		test.setG(0);
		assertEquals(false,test.equals(test2));
		
		//b=1 other.b=0
		test.setB(1);
		assertEquals(false,test.equals(test2));
		
		//equal
		test.setB(0);
		assertEquals(true,test.equals(test2));
		
	}
	
	//int hashCode()
	@Test
	public void testHashCode() {
		final int prime = 31;
		ScreenColor test = new ScreenColor();
		int expected = prime * prime * prime;
		
		//r=null g=null b=null
		assertEquals(expected,test.hashCode());
	
		//r=1 g=null b=null
		test.setR(1);
		expected = prime+test.getR().hashCode();
		expected *= prime*prime;
		assertEquals(expected,test.hashCode());
		
		//r=1 g=1 b=null
		test.setG(1);
		expected = prime+test.getR().hashCode();
		expected = expected*prime + test.getG().hashCode();
		expected *= prime;
		assertEquals(expected,test.hashCode());
		
		//r=1 g=1 b=1
		test.setB(1);
		expected += test.getB().hashCode();
		assertEquals(expected,test.hashCode());

		//r=null g=1 b=null
		test = new ScreenColor();
		test.setG(1);
		expected = prime*prime + test.getG().hashCode();
		expected *= prime;
		assertEquals(expected,test.hashCode());
		
		//r=null g=1 b=1
		test.setB(1);
		expected += test.getB().hashCode();
		assertEquals(expected,test.hashCode());
		
		//r=null g=null b=1
		test = new ScreenColor();
		test.setB(1);
		expected = prime*prime*prime + test.getB().hashCode();
		assertEquals(expected,test.hashCode());
		
		//r=1 g=null b=1
		test.setR(1);
		expected = prime+ test.getR().hashCode();
		expected *= prime;
		expected = expected*31 + test.getB().hashCode(); 
		assertEquals(expected,test.hashCode());
		
		
	}

}
