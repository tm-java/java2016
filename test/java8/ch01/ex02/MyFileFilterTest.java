package java8.ch01.ex02;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class MyFileFilterTest {

	@Test
	public void testL() {
		File file = new File("src/jpl/ch24");
		String[] expected = new String[] {
				"[src/jpl/ch24/ex01, src/jpl/ch24/ex02]"
		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		MyFileFilter.showSubDirectoryL(file);
		
		sc.stop();
		sc.assertEquals(expected);	
	}
	
	@Test
	public void testM() {
		File file = new File("src/jpl/ch24");
		String[] expected = new String[] {
				"[src/jpl/ch24/ex01, src/jpl/ch24/ex02]"
		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		MyFileFilter.showSubDirectoryM(file);
		
		sc.stop();
		sc.assertEquals(expected);	
	}

}
