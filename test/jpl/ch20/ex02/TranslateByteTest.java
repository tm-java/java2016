package jpl.ch20.ex02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Test;

public class TranslateByteTest {
	InputStream tis;
	OutputStream tos;

	@Test
	public void testFile() throws FileNotFoundException {
		byte from = 'b';
		byte to = 'B';
		byte[] expected = "aBracadaBra!".getBytes();
		String input = "test/jpl/ch20/ex01/FileInput.txt";
	
		File testFile = new File(input);
		tis = new FileInputStream(testFile);
		FilterInputStream fis = new TranslateByte(tis, from, to);
		try {
			int r = 0;
			int i = 0;
			while ((r = fis.read()) != -1) {
				assertEquals(expected[i], (byte)r);
				i++;
			}
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				tis.close();
			} catch (IOException e) {
			}
		}
	}

}
