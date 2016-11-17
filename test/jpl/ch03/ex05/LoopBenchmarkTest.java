package jpl.ch03.ex05;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class LoopBenchmarkTest {

	/*経過時間が毎回違うので、一旦コメントアウト
	@Test
	public void testMain() {
		String[] expected = new String[] {"Hello World",
				"Hello World",
				"Hello World",
				"Hello World",
				"Hello World",
				"Hello World",
				"Hello World",
				"Hello World",
				"Hello World",
				"Hello World"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		LoopBenchmark.main(new String[]{"10"});

		sc.stop();
		sc.assertEquals(expected);
	}
	*/

	//こっちはベンチマークへのアクセスができず
	@Test
	public void testBenchmark() {
		String[] expected = new String[] {"Hello World"};

		StdoutCapture sc = new StdoutCapture();
		sc.start();

		LoopBenchmark.benchmark();

		sc.stop();
		sc.assertEquals(expected);
	}
	


}
