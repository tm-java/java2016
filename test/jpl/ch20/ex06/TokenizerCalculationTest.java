package jpl.ch20.ex06;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class TokenizerCalculationTest {

	@Test
	public void test() {
		String input = "data1 = 3\n data2 = 4\n data3 = 5\n data1 + 1\n data2 - 0\n data3 - 1\n";
		String[] expected = {
				"data3 = 4.0",
				"data2 = 4.0",
				"data1 = 4.0",
		};
		
		StringReader sr = new StringReader(input);
		TokenizerCalculation tc = new TokenizerCalculation();
		try {
			StdoutCapture sc = new StdoutCapture();
			sc.start();
			
			tc.calculation(sr);
			
			sc.stop();
			sc.assertEquals(expected);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
