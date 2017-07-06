package jpl.ch20.ex04;

import java.io.BufferedReader;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/*
 * ちゃんと自分で待つ実装を入れる
 */
public class LineFilterReader extends FilterReader {
	BufferedReader br;
	
	protected LineFilterReader(Reader in) {
		super(in);
		br = new BufferedReader(in);
	}
	
	public String readLine() throws IOException {
		return br.readLine();
	}

}
