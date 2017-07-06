package java8.ch01.ex09;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class Collection2Test {

	@Test
	public void test() {
		Collection2<String> c2 = new ArrayList2<>();
		c2.add("abc"); c2.add("Def"); c2.add("gHi");
		String[] expected = {
			"Def",
			"gHi"
		};
		
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		c2.forEachIf( System.out::println, str -> str.matches(".*[A-Z]+.*"));
		
		sc.stop();
		sc.assertEquals(expected);
	}

}
