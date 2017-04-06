package jpl.ch17.ex02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class DataHandlerTest {
	DataHandler dh = new DataHandler();
	File testFile = new File("test/jpl/ch17/ex02/testData.txt");
	byte[] testFileByteData = null;

	public DataHandlerTest() {
		try {
			testFileByteData = dh.readBytesFromFile(testFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test1() {
		byte[] result = null;
		try {
			result = dh.readFile(testFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(testFileByteData.length, result.length);
		for (int i = 0; i < testFileByteData.length; i++) {
			assertEquals(testFileByteData[i], result[i]);
		}
	}

	@Test
	public void test2() {
		DataHandler dh = new DataHandler();
		byte[] result = null;
		try {
			result = dh.readFile(testFile);
			result = dh.readFile(testFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(testFileByteData.length, result.length);
		for (int i = 0; i < testFileByteData.length; i++) {
			assertEquals(testFileByteData[i], result[i]);
		}
	}

}
