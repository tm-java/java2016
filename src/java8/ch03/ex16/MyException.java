package java8.ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MyException {
	public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
		Thread t = new Thread() {
			public void run() {
				T result = null;
				try {
					result = first.get();
					second.accept(result, null);
				} catch (Throwable t) {
					second.accept(result, t);
				}
			}
		};
		t.start();
	}

}
