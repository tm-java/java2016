package jpl.ch20.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {

	public static OutputStream translateByte(InputStream is, OutputStream os, byte from, byte to) throws IOException {
		int b;
		while ((b = is.read()) != -1) {
			os.write(b == from ? to : b);
		}
		return os;
	}
}
