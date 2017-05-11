package jpl.ch22.ex07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CSVScanner {
	public static List<String[]> readCSVTable(Readable source, int n) throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();

		StringBuilder s = new StringBuilder("^");
		for (int i = 0; i < n; i++) {
			s.append("(.*),");
		}
		s.deleteCharAt(s.length() - 1);
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
				vals.add(cells);
				in.nextLine();
			} else {
				throw new IOException("input format error");
			}
		}
		IOException ex = in.ioException();
		if (ex != null) {
			throw ex;
		}
		return vals;
	}

}
