package jpl.ch20.ex05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindWord {
	public static void findWords(String file, String word) throws IOException {
		FileReader fr = new FileReader(file);
		LineNumberReader in = new LineNumberReader(fr);
		int c;
		StringBuilder sb = new StringBuilder();
		while ((c = in.read()) != -1) {
			sb.append((char)c);
			if (word.equals(sb.toString())) {
				System.out.println("\"" + word + "\" at line " + in.getLineNumber());
				sb = new StringBuilder();
			}
			
			if (sb.length() >= word.length()) {
				sb = new StringBuilder(sb.subSequence(1, word.length()));
			}
		}
	}
}
