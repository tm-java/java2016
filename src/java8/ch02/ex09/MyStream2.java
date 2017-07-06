package java8.ch02.ex09;

import java.util.ArrayList;
import java.util.stream.Stream;

public class MyStream2 {
	public static <T> ArrayList<T> toArrayList1(Stream<ArrayList<T>> stream) {
		return stream.reduce(
			(list1, list2) -> {list1.addAll(list2); return list1;}
			).get();
	}
	
	public static <T> ArrayList<T> toArrayList2(Stream<ArrayList<T>> stream) {
		return stream.reduce(
				new ArrayList<T>(),
				(list1, list2) -> {list1.addAll(list2); return list1;});
	}

	public static <T> ArrayList<T> toArrayList3(Stream<ArrayList<T>> stream) {
		return stream.reduce(
				new ArrayList<T>(),
				(list1, list2) -> {list1.addAll(list2); return list1;},
				(total1, total2) -> {total1.addAll(total2); return total1;});
	}

}
