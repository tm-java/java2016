package jpl.ch20.ex11;

import java.io.File;
import java.io.FilenameFilter;

public class SuffixFilter implements FilenameFilter {

	private final String suffix;
	
	public SuffixFilter(String suffix) {
		this.suffix = suffix;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return suffix.equals(name.substring(name.length()-suffix.length(), name.length()));
	}
	
	public static void main(String[] args) {
		File dir = new File(args[0]);
		String[] files = dir.list(new SuffixFilter(args[1]));
		for (String file : files) {
			System.out.println(file);
		}
	}

}
