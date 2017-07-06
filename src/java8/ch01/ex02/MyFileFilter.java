package java8.ch01.ex02;

import java.io.File;
import java.util.Arrays;

public class MyFileFilter {
	
	public static void showSubDirectoryL(File file) {
		File[] lists = file.listFiles(f -> f.isDirectory());
		System.out.println(Arrays.toString(lists));
	}
	
	public static void showSubDirectoryM(File file) {
		File[] lists = file.listFiles(File::isDirectory);
		System.out.println(Arrays.toString(lists));
	}


}
