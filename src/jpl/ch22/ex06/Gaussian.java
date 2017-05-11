package jpl.ch22.ex06;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Gaussian {
	public static void displayGraph(Map<Integer, Integer> data) {
		for (Map.Entry<Integer, Integer> e : data.entrySet()) {
			System.out.printf("%+3d :", e.getKey());
			int n = e.getValue();
			for (int i = 0; i < n; i += 50 ) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Random r = new Random();
		Map<Integer, Integer> data = new TreeMap<Integer, Integer>();
		for (int i = 0; i < 100000; i++) {
			int key = (int) (r.nextGaussian() * 10);
			int v = 0;
			if (data.containsKey(key)) {
				v = data.get(key);
			}
			v++;
			data.put(key, v);
		}
		Gaussian.displayGraph(data);
	}

}
