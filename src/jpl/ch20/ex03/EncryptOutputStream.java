package jpl.ch20.ex03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream {
	private static final int CRYPT = 0xF;

	public EncryptOutputStream(OutputStream out) {
		super(out);
	}

	public void write(int b) throws IOException {
		super.write((b ^ CRYPT));
	}

	public void write(byte[] buf, int offset, int count) throws IOException {
		if (buf == null) {
			throw new NullPointerException();
		}
		if (offset < 0 || count < 0 || (offset + count) > buf.length) {
			throw new IndexOutOfBoundsException();
		}
		
		for (int i = offset; i < offset + count; i++) {
			this.write(buf[i]);
		}
	}
	
	public void write(byte[] buf) throws IOException {
		this.write(buf, 0, buf.length);
	}

}
