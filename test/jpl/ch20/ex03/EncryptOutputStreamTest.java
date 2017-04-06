package jpl.ch20.ex03;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import org.junit.Test;

public class EncryptOutputStreamTest {
	int crypt = 0xF;
	
	@Test
	public void test1() {
		byte[] data = "abcde".getBytes();
		byte[] expected = new byte[data.length];
		
		for (int i = 0 ; i < data.length ; i++) {
			expected[i] = (byte) (data[i] ^ crypt); 
		}
		
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		FilterOutputStream aos = new EncryptOutputStream(bas);
		try {
			aos.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertTrue(Arrays.equals(expected, bas.toByteArray()));
	}
	
	@Test(expected = NullPointerException.class)
	public void test2() {
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		FilterOutputStream aos = new EncryptOutputStream(bas);
		try {
			bas.write(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test3() {
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		FilterOutputStream aos = new EncryptOutputStream(bas);
		byte[] data = "abcde".getBytes();
		bas.write(data, -1, 1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test4() {
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		FilterOutputStream aos = new EncryptOutputStream(bas);
		byte[] data = "abcde".getBytes();
		bas.write(data, 0, -1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void test5() {
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		FilterOutputStream aos = new EncryptOutputStream(bas);
		byte[] data = "abcde".getBytes();
		bas.write(data, 3, data.length);
	}

}
