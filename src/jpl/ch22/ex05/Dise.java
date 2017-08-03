package jpl.ch22.ex05;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

//理論値分布を計算して表示
public class Dise {
	public static long play(int n) {
		long sum = 0;
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			sum += (r.nextInt(6) + 1);
		}
		return sum;
	}

	public static Map<Long, Integer> playFor(int n, int dise) {
		Map<Long, Integer> data = new TreeMap<Long, Integer>();
		for (int i = 0; i < n; i++) {
			long sum = Dise.play(dise);
			int v = 0;
			if (data.containsKey(sum)) {
				v = data.get(sum);
			}
			v++;
			data.put(sum, v);
		}
		return data;
	}

	public static void main(String[] args) {
		Map<Long, Integer> data = Dise.playFor(10000, 1);
		for (Map.Entry<Long, Integer> e : data.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
}
