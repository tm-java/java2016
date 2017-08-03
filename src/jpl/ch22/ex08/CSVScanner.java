package jpl.ch22.ex08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CSVScanner {
	static final String LINE_SEPARATOR_PATTERN = "\r\n|[\n\r\u2028\u2029\u0085]";
	public static List<String[]> readCSVTable(Readable source, int n) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();

		StringBuilder s = new StringBuilder("^");
		for (int i = 0; i < n; i++) {
			s.append("([^,]*?),");//＋ではなくて、０以上で
		}
		s.deleteCharAt(s.length() - 1);
		s.append("$");
		String exp = s.toString();

		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[n];
				MatchResult match = in.match();
				for (int i = 0; i < n; i++) {
					cells[i] = match.group(i + 1);
				}
				String str = in.nextLine();
				if (!str.matches(LINE_SEPARATOR_PATTERN) && !str.equals("")) {
					throw new IOException("input format error!");
				} else {
					vals.add(cells);
				}
			} else {
				String str = in.nextLine();
				if (!str.matches(LINE_SEPARATOR_PATTERN) && !str.equals("")) {
					throw new IOException("input format error");
				} 
			}
		}
		IOException ex = in.ioException();
		if (ex != null) {
			throw ex;
		}
		return vals;
	}

}
