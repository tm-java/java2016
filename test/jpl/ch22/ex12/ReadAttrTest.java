package jpl.ch22.ex12;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class ReadAttrTest {

	@Test
	public void test() throws IOException {
		String input = "data1=3\ndata2=4\ndata3=5\n";
		Set<String> expected = new HashSet<String>();
		expected.add("data3 = '5'");
		expected.add("data2 = '4'");
		expected.add("data1 = '3'");
		
		StringReader sr = new StringReader(input);
		Attributed attrs = ReadAttr.readAttrs(sr);
		Iterator<Attr> ite = attrs.attrs();
		int i = 0;
		while (ite.hasNext()) {
			assertTrue(expected.contains(ite.next().toString()));
			i++;
		}
		assertEquals(expected.size(), i);
	}

}
