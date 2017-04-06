package jpl.ch20.ex05;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class FindWordTest {

	@Test
	public void test1() {
		String file = "test/jpl/ch20/ex05/testData1.txt";
		String word = "is";
		String[] expected = new String[] {
				"\"is\" at line 7"
				};
		
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		try {
			FindWord.findWords(file, word);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.stop();
		sc.assertEquals(expected);
	}
	
	@Test
	public void test2() {
		String file = "test/jpl/ch20/ex05/testData2.txt";
		String word = "aa";
		String[] expected = new String[] {
				"\"aa\" at line 0",
				"\"aa\" at line 0",
				"\"aa\" at line 1",
				"\"aa\" at line 2",
				"\"aa\" at line 2",
				"\"aa\" at line 2",
				};
		
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		try {
			FindWord.findWords(file, word);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
