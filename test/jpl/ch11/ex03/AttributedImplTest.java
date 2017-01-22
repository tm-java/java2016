package jpl.ch11.ex03;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class AttributedImplTest {

	@Test
	public void test() {
		//main
				String[] expected = new String[] {
					"a = \'aa\'",
					"b = \'1\'",
				};

				StdoutCapture sc = new StdoutCapture();
				sc.start();
				
				AttributedImpl.main(new String[0]);
				
				sc.stop();
				sc.assertEquals(expected);
	}

}
