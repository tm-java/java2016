package jpl.ch20.ex11;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class SuffixFilterTest {

	@Test
	public void test() {
		// main
		String[] expected = new String[] { "SuffixFilter.java" };

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		SuffixFilter.main(new String[] { "src/jpl/ch20/ex11", ".java" });

		sc.stop();
		sc.assertEquals(expected);
	}

}
