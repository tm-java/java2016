package jpl.ch20.ex02;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte extends FilterInputStream{
	private byte from;
	private byte to;
	protected TranslateByte(InputStream in, byte from, byte to) {
		super(in);
		this.from = from;
		this.to = to;
	}
	
	public int read() throws IOException{
		int c = super.read();
		if (c == -1) {
			return c;
		}
		return (c == from ? to : c);
	}

}
