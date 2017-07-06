package java8.ch02.ex10;

import java.util.stream.Stream;

/**
 * count()を使えない理由
 * count()を呼び出した時には、もう終端操作であるから
 */
public class MyDouble {
	public static double average(Stream<Double> stream) {
		return stream.reduce(
				new double[3],
				(x, y) -> {x[0] += y; x[1] += 1.0; x[2] = x[0] / x[1]; return x;},
				(t1, t2) -> {t1[0] += t2[0]; t1[1] += t2[1]; t1[2] = t1[0] / t1[1]; return t1;}
				)[2];
	}

}
