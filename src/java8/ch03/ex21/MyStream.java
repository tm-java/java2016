package java8.ch03.ex21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class MyStream {
	public static <T, U> Future<U> map(Future<T> f, Function<T, U> fc) {
		return new Future<U>() {
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return f.cancel(mayInterruptIfRunning);
			}

			@Override
			public boolean isCancelled() {
				return f.isCancelled();
			}

			@Override
			public boolean isDone() {
				return f.isDone();
			}

			@Override
			public U get() throws InterruptedException, ExecutionException {
				return fc.apply(f.get());
			}

			@Override
			public U get(long timeout, TimeUnit unit)
					throws InterruptedException, ExecutionException, TimeoutException {
				return fc.apply(f.get(timeout, unit));
			}
			
		};
		
	}

}
