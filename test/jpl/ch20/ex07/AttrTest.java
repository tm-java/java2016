package jpl.ch20.ex07;

import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class AttrTest {

	@Test
	public void writeTest() {
		String data = "writeTest";
		String output = null;
		Attr at = new Attr(data);
		
		String file = "test/jpl/ch20/ex07/writeTest.txt";
		try {
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			at.writeData(dos);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		try {
			FileReader fr = new FileReader(file);
			int c;
			StringBuilder sb = new StringBuilder();
			while ((c = fr.read()) != -1) {
				sb.append((char)c);
			}
			output = sb.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals(data, output);
		//なぜ、writeUTFすると文字の前に空白が入るのかわかりません
	}
	
	@Test
	public void readTest() {
		String file = "test/jpl/ch20/ex07/readTest.txt";
		String expected = "readTest";
		Attr at = null;
		
		//readUTFを使うには、writeUTFで書き込んでいる必要がある。
		try {
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.writeUTF(expected);
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			at = new Attr(dis);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(expected, at.getName());
	}

}
