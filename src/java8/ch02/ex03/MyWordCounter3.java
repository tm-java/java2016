package java8.ch02.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MyWordCounter3 {
	public static void main(String[] args) {
		List<String> words = null;
		try {
			String contents = new String(Files.readAllBytes(Paths.get("src/java8/ch02/ex03/Stream.txt")), StandardCharsets.UTF_8);
			words = Arrays.asList(contents.split("[\\P{L}]+"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long start = System.nanoTime();
		long s = words.stream().filter(w -> w.length() > 12).count();
		long end = System.nanoTime();
		System.out.println((end - start) + " : stream");
		
		start = System.nanoTime();
		s = words.parallelStream().filter(w -> w.length() > 12).count();
		end = System.nanoTime();
		System.out.println((end - start) + " : parallel stream");
	}

}
