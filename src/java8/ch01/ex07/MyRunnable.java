package java8.ch01.ex07;

public class MyRunnable {
	public static Runnable andThen(Runnable runner1, Runnable runner2) {
		Runnable r = () -> {
			runner1.run();
			runner2.run();
		};
		return r;
	}

}
