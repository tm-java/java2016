package java8.ch03.ex18;

import static org.junit.Assert.*;

import java.util.function.Function;

import org.junit.Test;

public class MyUncheckedExceptionTest {

	@Test
	public void test() {
		try {
			Function<String, String> hello = MyUncheckedException.unchecked((t) -> {
				throw new Exception(t + "!!");
			});
			System.out.println(hello.apply("hello"));
		} catch (Exception e) {
			assertEquals("java.lang.Exception: hello!!", e.getMessage());
		}
	}

}
