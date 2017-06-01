package jpl.ch22.ex11;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CSVStreamTokenizerTest {

	@Test
	public void test() {
		String input = "a,b,c\nd,e,f\ng,h,i\nj,k,l\n";
		String[][] expected = { 
				{ "a", "b", "c" },
				{ "d", "e", "f" },
				{ "g", "h", "i" },
				{ "j", "k", "l" }
		};

		StringReader sr = new StringReader(input);
		List<String[]> actual;
		try {
			actual = CSVStreamTokenizer.readCSVTable(sr, 3);
			int i = 0;
			for (String[] ss : actual) {
				assertTrue(Arrays.equals(expected[i], ss));
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
