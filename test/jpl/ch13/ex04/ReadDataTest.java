package jpl.ch13.ex04;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;


public class ReadDataTest {

	@Test
	public void testS() {
		String path = "test/jpl/ch13/ex04/test_data_success";
		String[] expected = new String[] {
				"1",
				"2",
				"3",
				"4",
				"5.5",
				"6.6",
				"a",
				"true",
			};

			StdoutCapture sc = new StdoutCapture();
			sc.start();
			
			ReadData.readData(path);
			
			sc.stop();
			sc.assertEquals(expected);
	}
	
	@Test
	public void testF() {
		String path = "test/jpl/ch13/ex04/test_data_fail";
		String[] expected = new String[] {
				"Not Object",
			};

			StdoutCapture sc = new StdoutCapture();
			sc.start();
			
			ReadData.readData(path);
			
			sc.stop();
			sc.assertEquals(expected);
	}

	
	//FileNotFoundExceptionのテストを書きたかった

	
	//IOException起こさせるテスト書きたかった
	

}
