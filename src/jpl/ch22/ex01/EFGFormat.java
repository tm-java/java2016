package jpl.ch22.ex01;

import java.util.Formatter;

public class EFGFormat {

	public static void formatDisplay(double[] ds, int n) {
		if (n > 80) {
			throw new IllegalArgumentException();
		}

		Formatter fm = new Formatter();
		
		for (double d : ds) {
			System.out.println(new Formatter().format("%." + n + "f", d));
		}
	}

}
