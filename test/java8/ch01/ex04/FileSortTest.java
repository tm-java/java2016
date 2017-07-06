package java8.ch01.ex04;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class FileSortTest {
	
	@Test
	public void test() {
		File[] files = new File("src/jpl/ch24/ex01").listFiles();
		File[] dirs = new File("src/jpl/ch24").listFiles();
		File[] lists = new File[files.length + dirs.length];
		System.arraycopy(files, 0, lists, 0, files.length);
		System.arraycopy(dirs, 0, lists, files.length, dirs.length);
		File[] expected = initExpected();
		
		File[] sorted = FileSort.sort(lists);
		
		assertTrue(Arrays.equals(expected, sorted));
	}
	
	private File[] initExpected() {
		File[] rtn = new File[7];
		rtn[0] = new File("src/jpl/ch24/ex01");
		rtn[1] = new File("src/jpl/ch24/ex02");
		rtn[2] = new File("src/jpl/ch24/ex01/GlobalHello.java");
		rtn[3] = new File("src/jpl/ch24/ex01/GlobalRes.java");
		rtn[4] = new File("src/jpl/ch24/ex01/GlobalRes_en.java");
		rtn[5] = new File("src/jpl/ch24/ex01/GlobalRes_en_AU.properties");
		rtn[6] = new File("src/jpl/ch24/ex01/GlobalRes_ja_JP.java");
		return rtn;
	}

}
