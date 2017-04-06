package jpl.ch20.ex03;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

import org.junit.Test;

public class DecryptInputStreamTest {
	
	@Test
	public void test() {
		byte[] data = "abcde".getBytes();
		
		//暗号化
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		FilterOutputStream aos = new EncryptOutputStream(bas);
		try {
			aos.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//復号化
		byte[] a = bas.toByteArray();
		ByteArrayInputStream bis = new ByteArrayInputStream(a);
		FilterInputStream fis = new DecryptInputStream(bis);
		int b;
		int i = 0;
		try {
			while ((b = fis.read()) != -1) {
				assertEquals(data[i], b);
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
