package jpl.ch22.ex09;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CSVScanner {
	class Bench1 extends Benchmark {
		Scanner in;
		String exp;
		Pattern pat;
		
		Bench1(Readable source){
			in = new Scanner(source);
			exp = "^([^,]+,)*([^,]+)";
			pat = Pattern.compile(exp, Pattern.MULTILINE);
		}
		@Override
		void benchmark() {
			while (in.hasNextLine()) {
				String line = in.findInLine(pat);
				in.nextLine();
			}
		}
	}
	
	class Bench2 extends Benchmark {
		Scanner in;
		String exp;
		Pattern pat;
		
		Bench2(Readable source, int n){
			in = new Scanner(source);
			exp = "^([^,]+,){"+(n-1)+"}([^,]+)";
			pat = Pattern.compile(exp, Pattern.MULTILINE);
		}
		@Override
		void benchmark() {
			while (in.hasNextLine()) {
				String line = in.findInLine(pat);
				in.nextLine();
			}
		}
	}
	
	private class Bench3 extends Benchmark {
		Scanner in;
		String exp;
		Pattern pat;
		
		Bench3(Readable source, int n){
			in = new Scanner(source);
			StringBuilder s = new StringBuilder("^");
			for (int i = 0; i < n; i++) {
				s.append("([^,]+),");
			}
			s.deleteCharAt(s.length() - 1);
			exp = s.toString();
			pat = Pattern.compile(exp, Pattern.MULTILINE);
		}
		@Override
		void benchmark() {
			while (in.hasNextLine()) {
				String line = in.findInLine(pat);
				in.nextLine();
			}
		}
	}
	
	class Bench4 extends Benchmark {
		Scanner in;
		String exp;
		Pattern pat;
		
		Bench4(Readable source, int n){
			in = new Scanner(source);
			StringBuilder s = new StringBuilder("^");
			for (int i = 0; i < n; i++) {
				s.append("(.*),");
			}
			s.deleteCharAt(s.length() - 1);
			exp = s.toString();
			pat = Pattern.compile(exp, Pattern.MULTILINE);
		}
		@Override
		void benchmark() {
			while (in.hasNextLine()) {
				String line = in.findInLine(pat);
				in.nextLine();
			}
		}
	}
	
	public static void main(String[] args) {
		int count = 3000;
		
		String input = "a,b,c\nddddddddddddddddddddddddddddddd,eeeeeeeeeeeeeeeeeeeeeeeeeeeeeee,ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff\ng,h,i\nj,k,l\n";
		CSVScanner scanner = new CSVScanner();
		List<Benchmark> bs = new ArrayList<Benchmark>();
		bs.add(scanner.new Bench1(new StringReader(input)));
		bs.add(scanner.new Bench2(new StringReader(input),3));
		bs.add(scanner.new Bench3(new StringReader(input),3));
		bs.add(scanner.new Bench4(new StringReader(input),3));
		
		for (Benchmark b : bs) {
			long time = b.repeat(count);
			System.out.println(count + " methods in " + time + " nanoseconds");
		}

	}

	

}
