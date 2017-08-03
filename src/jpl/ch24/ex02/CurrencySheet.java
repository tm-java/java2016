package jpl.ch24.ex02;

import java.util.Currency;
import java.util.Locale;

public class CurrencySheet {
	public static void main(String[] args) { 
		Locale[] locales = new Locale[]{ Locale.ENGLISH, Locale.JAPAN, Locale.FRANCE, Locale.GERMAN, Locale.CHINA};
		/*Currency[] currs = new Currency[locales.length];
		currs[0] = Currency.getInstance(Locale.ENGLISH);
		currs[1] = Currency.getInstance(Locale.JAPAN);
		currs[2] = Currency.getInstance(Locale.FRANCE);
		currs[3] = Currency.getInstance(Locale.GERMAN);
		currs[4] = Currency.getInstance(Locale.CHINA);
		currs[5] = Currency.getInstance(Locale.CANADA);*/
		
		for (int i = 0; i < locales.length; i++) {
			System.out.print(locales[i].toString() + "\t");
			Currency curr = Currency.getInstance(Locale.ENGLISH);
			for (int j = 0; j < locales.length; j++) {
				System.out.print(curr.getSymbol(locales[i]) + " ");
			}
			System.out.println();
			
		}
		
	}
}
