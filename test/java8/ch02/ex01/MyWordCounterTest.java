package java8.ch02.ex01;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MyWordCounterTest {

	@Test
	public void test() throws IOException {
		MyWordCounter mwc = new MyWordCounter();
		String contents = new String(Files.readAllBytes(Paths.get("test/java8/ch02/ex01/input.txt")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
		mwc.parallelWordCount(words, 12);
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(5, mwc.count());
	}

}
