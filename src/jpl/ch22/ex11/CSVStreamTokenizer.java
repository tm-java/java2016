package jpl.ch22.ex11;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CSVStreamTokenizer {
	public static List<String[]> readCSVTable(Reader source, int n) throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		List<String[]> vals = new ArrayList<String[]>();
		in.whitespaceChars(',', ',');
		int col = 0;
		String[] line = new String[n];
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			
			if (in.ttype == StreamTokenizer.TT_WORD) {
				line[col] = in.sval;
			} else if (in.ttype == StreamTokenizer.TT_NUMBER) {
				line[col] = String.valueOf(in.nval);
			}
			col++;
			if (col >= n) {
				vals.add(line);
				line = new String[n];
				col = 0;
			}
		}
		return vals;
	}

}
