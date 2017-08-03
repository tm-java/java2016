package java8.ch03.ex17;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MyException {
	public static <T> void doInOrderAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
		Thread f = new Thread() {
			public void run() {
				try {
					first.run();
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		Thread s = new Thread() {
			public void run() {
				try {
					second.run();
				} catch (Throwable t) {
					handler.accept(t);
				}
			}
		};
		f.start();
		s.start();
	}

}
