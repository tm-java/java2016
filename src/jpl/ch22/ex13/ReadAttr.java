package jpl.ch22.ex13;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ReadAttr {
	public static Attributed readAttrs(Readable source) throws IOException {
		Scanner in = new Scanner(source);
		AttributedImpl attrs = new AttributedImpl();
		Attr attr = null;

		String exp = "(.*?)=(.*)";
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);

		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				MatchResult match = in.match();
				if (match.group(1).equals("") || match.group(2).contains("=")) {
					throw new IOException("misplaced '='");
				}
				
				attr = new Attr(match.group(1), match.group(2));
				attrs.add(attr);
				in.nextLine();
			} else {
				throw new IOException("input format error");
			}
		}
		
		IOException ex = in.ioException();
		if (ex != null) {
			throw ex;
		}
		return attrs;
	}
}
