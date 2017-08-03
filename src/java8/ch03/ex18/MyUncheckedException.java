package java8.ch03.ex18;

import java.util.function.Function;

public class MyUncheckedException {
	public static <T, R> Function<T, R> unchecked(CallableFunction<T, R> f) {
		return (t) -> {
			try {
				return f.applay(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} catch (Throwable th) {
				throw th;
			}
		};
		
	}

}
