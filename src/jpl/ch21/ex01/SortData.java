package jpl.ch21.ex01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SortData {

	public static List sortData(String file) throws IOException {
		FileReader fr = new FileReader(file);
		LineFilterReader lfr = new LineFilterReader(fr);
		String read = null;
		List<String> rtn = new LinkedList<String>();

		while ((read = lfr.readLine()) != null) {
			int i = 0;
			for (i = 0; i < rtn.size(); i++) {
				if ((rtn.get(i)).compareTo(read) >= 0) {
					rtn.add(i, read);
					break;
				}
			}
			if (i == rtn.size()) {
				rtn.add(read);
			}
		}
		return rtn;
	}

}
