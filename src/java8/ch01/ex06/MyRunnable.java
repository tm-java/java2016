package java8.ch01.ex06;

public class MyRunnable {
	public static Runnable uncheck(RunnableEx runner) {
		Runnable r = () -> {
			try {
				runner.run();
			} catch(Exception e){
				throw new RuntimeException();
			}
		};
		return r;
	}
}
