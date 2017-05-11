package jpl.ch22.ex08;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CSVScannerTest {

	@Test
	public void test() throws IOException {
		String input = "a,b,c\nd,e,f\ng,h,i\nj,k,l\n\n";
		String[][] expected = { { "a", "b", "c" }, { "d", "e", "f" }, { "g", "h", "i" }, { "j", "k", "l" } };

		StringReader sr = new StringReader(input);
		List<String[]> actual;
		actual = CSVScanner.readCSVTable(sr, 3);
		int i = 0;
		for (String[] ss : actual) {
			for (int j = 0; j < expected[i].length; j++) {
				assertEquals(expected[i][j], ss[j]);
			}
			i++;
		}

	}

	@Test(expected = IOException.class)
	public void test2() throws IOException {
		String input = "a,b,c,d,e\nd,e,f\ng,h,i\nj,k,l\n";
	
		StringReader sr = new StringReader(input);
		CSVScanner.readCSVTable(sr, 3);
	}

}
