package jpl.ch20.ex01;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
		String output = "test/jpl/ch20/ex01/FileOutputActual.txt";

		File testFile = new File(input);
		tis = new FileInputStream(testFile);
		tos = new FileOutputStream(output);
		try {
			TranslateByte.translateByte(tis, tos, from, to);
			assertTrue(Arrays.equals(expected, Files.readAllBytes(Paths.get(output))));
		}catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				tis.close();
				tos.close();
			} catch (IOException e) {
			}
		}
	}

}
