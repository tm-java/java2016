package jpl.ch03.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorAttrTest {

	//ColorAttr(String name,Object value)
	@Test
	public void testNew() {
		ColorAttr test = new ColorAttr("test","blue");
		ScreenColor sc = new ScreenColor("blue");
		assertNotNull(test);
		assertEquals("test",test.getName());
		assertEquals("blue",test.getValue());
		assertEquals(sc,test.getColor());
	}
	
	//ColorAttr(String name)???????
	@Test
	public void testNew2() {
		ColorAttr test = new ColorAttr("test");
		ScreenColor sc = new ScreenColor();
		assertNotNull(test);
		assertEquals("test",test.getName());
		assertEquals("transparent",test.getValue());
		assertEquals(sc,test.getColor());
	}
	
	
	//ColorAttr(String name,ScreenColor value)
	@Test
	public void testNew3() {
		ScreenColor sc = new ScreenColor("blue");
		ColorAttr test = new ColorAttr("test",sc);
		assertNotNull(test);
		assertEquals("test",test.getName());
		assertEquals("blue",test.getValue());
		assertEquals(sc,test.getColor());
	}
	
	
	//Object setValue(Object newValue)
	@Test
	public void testValue() {
		ScreenColor sc = new ScreenColor("green");
		ColorAttr test = new ColorAttr("test","blue");
		Object obj = test.setValue("green");
		assertEquals("blue",obj);
		assertEquals("green",test.getValue());
		assertEquals(sc,test.getColor());
	}
	
	//ScreenColor setValue(ScreenColor newValue)
	@Test
	public void testValue2() {
		ScreenColor scAfter = new ScreenColor("green");
		ScreenColor scBefore = new ScreenColor("blue");
		ColorAttr test = new ColorAttr("test","blue");
		ScreenColor rtn = test.setValue(scAfter);
		assertEquals(scBefore,rtn);
		assertEquals("green",test.getValue());
		assertEquals(scAfter,test.getColor());
	}
	
	//void decodeColor()
	@Test
	public void testDecodeColor() {
		ColorAttr testNull = new ColorAttr("test");
		Object objNull = null;
		testNull.setValue(objNull);
		
		//null
		testNull.decodeColor();
		assertNull(testNull.getColor());
		
	}
	
	//String toString()
	@Test
	public void testToString() {
		ColorAttr testR = new ColorAttr("test","red");
		assertEquals("test = 'red' (red)",testR.toString());
	}
	
	//boolean equals(Object obj)
	@Test
	public void testEquals() {
		ColorAttr test = new ColorAttr("test","red");
		ColorAttr test2 = new ColorAttr("test","red");
		assertEquals(true,test.equals(test));
		assertEquals(false,test.equals(null));
		assertEquals(false,test.equals(1));
		
		ColorAttr test3 = new ColorAttr("myColorNull");
		ColorAttr test4 = new ColorAttr("test","blue");
		assertEquals(false,test3.equals(test));
		assertEquals(false,test.equals(test4));
		assertEquals(true,test.equals(test2));
		
	}
	
	//int hashCode()
	@Test
	public void testHashCode() {
		ColorAttr testNull = new ColorAttr("test");
		Object objNull = null;
		testNull.setValue(objNull);
		
		ScreenColor sc = new ScreenColor(1,1,1);
		ColorAttr test111 = new ColorAttr("test",sc);
		
		
		int expected = 31+sc.hashCode();
		
		assertEquals(31,testNull.hashCode());
		assertEquals(expected,test111.hashCode());
	}
	
}
