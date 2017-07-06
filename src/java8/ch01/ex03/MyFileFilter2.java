package java8.ch01.ex03;

import java.io.File;
import java.util.Arrays;

public class MyFileFilter2 {
	
	public static void showFiles(File file, String name) {
		File[] lists = file.listFiles((f,n) -> n.endsWith(name));
		System.out.println(Arrays.toString(lists));
	}

}
