package jpl.ch22.ex10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkipComment {
	public static List<String> skipComment(Readable source) throws IOException {
		Scanner in = new Scanner(source);
		in.useDelimiter("(\n)*#.*\n|\n");//先にコメントの方をデリミタにマッチさせる
		List<String> rtn = new ArrayList<String>();
		
		while (in.hasNext()) {
			rtn.add(in.next());
		}
		
		IOException ex = in.ioException();
		if (ex != null) {
			throw ex;
		}
		return rtn;
	}
}
