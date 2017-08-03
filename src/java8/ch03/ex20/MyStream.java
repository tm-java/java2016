package java8.ch03.ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MyStream {
	public static <T, U> List<U> map(List<T> l, Function<T, U> f){
		List<U> out = new ArrayList<>();
		for (T t : l) {
			out.add(f.apply(t));
		}
		return out;
	}

}
