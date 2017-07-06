package java8.ch02.ex02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MyWordCounter2 {
	public static void main(String[] args) {
		String contents;
		try {
			contents = new String(Files.readAllBytes(Paths.get("src/java8/ch02/ex02/input.txt")), StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
			Stream<String> s = words.stream().filter(w -> {
				System.out.println(w + " @filter");
				return w.length() > 12;
			}).limit(5);
			System.out.println(s.count());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
