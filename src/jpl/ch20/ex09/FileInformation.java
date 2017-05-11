package jpl.ch20.ex09;

import java.io.File;

public class FileInformation {
	
	public static void fileInformation(String... paths) {
		for (String path : paths) {
			File file = new File(path);
			System.out.println(file.getAbsolutePath());
			if (!file.exists()) {
				System.out.println("this is not exists");
				continue;
			}
			
			System.out.println(file.canRead() ? "can read" : "cannot read");
			System.out.println(file.canWrite() ? "can write" : "cannot write");
			System.out.println(file.isFile() ? "file" : "not file");
			System.out.println(file.isDirectory() ? "directry" :"not directry");
			System.out.println(file.isHidden() ? "hidden" : "not hidden");
			System.out.println("last modified : " + file.lastModified());
			System.out.println("length : " + file.length());
			
			if (file.isDirectory()) {
				System.out.println("lists : ");
				String[] lists = file.list();
				for (String s : lists) {
					System.out.println(" " + s);
				}
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		FileInformation.fileInformation("src/jpl/ch20/ex08", "src/jpl/ch20/ex08/song_data");
	}

}
