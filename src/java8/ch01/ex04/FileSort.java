package java8.ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileSort {
	public static File[] sort(File[] files) {
		Comparator<File> comp = (first, second) -> {
			if (first.isDirectory()) {
				if (second.isDirectory()) {
					return first.getAbsolutePath().compareTo(second.getAbsolutePath());
				} else {
					return -1;
				}
			} else {
				if (second.isDirectory()) {
					return 1;
				}
				return first.getAbsolutePath().compareTo(second.getAbsolutePath());
			}
		};
		Arrays.sort(files, comp);
		
		return files;
	}

}
