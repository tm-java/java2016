package jpl.ch22.ex14;

import java.util.StringTokenizer;

public class DoubleReader {
	public static double sumDouble(String source) {
		StringTokenizer tokens = new StringTokenizer(source);
		double sum = 0.0;
		while (tokens.hasMoreTokens()) {
			sum += Double.parseDouble(tokens.nextToken());
		}
		return sum;
	}

}
