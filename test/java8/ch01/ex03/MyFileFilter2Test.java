package java8.ch01.ex03;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class MyFileFilter2Test {

	@Test
	public void test() {
		File file = new File("src/jpl/ch24/ex01");
		String name = "properties";//キャプチャされる変数
		String[] expected = new String[] {
				"[src/jpl/ch24/ex01/GlobalRes_en_AU.properties]"
		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		MyFileFilter2.showFiles(file, name);
		
		sc.stop();
		sc.assertEquals(expected);
		
	}

}
