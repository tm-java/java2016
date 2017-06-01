package jpl.ch22.ex13;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class ReadAttrTest {

	@Test(expected = IOException.class)
	public void test() throws IOException {
		String input = "=3\n";
		Set<String> expected = new HashSet<String>();
		
		StringReader sr = new StringReader(input);
		Attributed attrs = ReadAttr.readAttrs(sr);
	}
	
	@Test(expected = IOException.class)
	public void test2() throws IOException {
		String input = "data1=3=4\n";
		Set<String> expected = new HashSet<String>();
		
		StringReader sr = new StringReader(input);
		Attributed attrs = ReadAttr.readAttrs(sr);
	}

}
