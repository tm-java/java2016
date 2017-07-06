package java8.ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public class MyLambda {
	public static void main(String[] args) {
		String[] names = { "Peter", "Paul", "Mary"};
		//拡張for
		List<Runnable> runners = new ArrayList<>();
		//各ラムダ式は異なる値をキャプチャする
		for (String name : names) {
			runners.add(() -> System.out.println(name));
		}
		for (Runnable r : runners) {
			new Thread(r).start();
		}
		
		//for
		/*
		 * コンパイルエラー
		runners = new ArrayList<>();
		for (int i = 0; i < names.length; i++) {
			runners.add(() -> System.out.println(names[i]));
		}
		for (Runnable r : runners) {
			new Thread(r).start();
		}
		*/
	}

}
