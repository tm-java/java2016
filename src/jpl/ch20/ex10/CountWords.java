package jpl.ch20.ex10;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class CountWords {
	public static Map<String, Integer> countWords(Reader source) throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		Map<String, Integer> rtn = new HashMap<String, Integer>();
		String key;
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_WORD) {
				key = in.sval;
				int count = 0;
				if (rtn.containsKey(key)) {
					count = rtn.get(key);
				}
				rtn.put(key, ++count);
			}
		}
		return rtn;
	}
}
