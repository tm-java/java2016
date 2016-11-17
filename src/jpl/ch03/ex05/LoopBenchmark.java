package jpl.ch03.ex05;

/**Hello Worldを出力するメソッドbenchmarkの呼び出しに要する時間と、ループのオーバーヘッドを測定する*/
public class LoopBenchmark extends Benchmark {

	@Override
	void benchmark() {
		System.out.println("Hello World");
	}

	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		long time = new LoopBenchmark().repeat(count);
		System.out.println(count + " methods in " + time + " nanoseconds");

	}

}
