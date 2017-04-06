package interpret;

import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.Vector;

import org.junit.Test;

public class ObjectsTest {

	@Test
	public void testMatchObjects1() {
		String aaa = "aaa";
		String bbb = "bbb";
		Object[] input = new Object[] { aaa, bbb, Integer.valueOf(1) };
		Objects obj = new Objects(input);
		Vector rtn = obj.matchObjects(String.class);
		assertTrue(rtn.contains(aaa));
		assertTrue(rtn.contains(bbb));
	}
	
	@Test
	public void testMatchObjects2() {
		String aaa = "aaa";
		String bbb = "bbb";
		Integer one = Integer.valueOf(1);
		Object[] input = new Object[] { aaa, bbb, one };
		Objects obj = new Objects(input);
		Vector rtn = obj.matchObjects(Integer.class);
		assertTrue(rtn.contains(one));
	}

}
