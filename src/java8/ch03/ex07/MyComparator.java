package java8.ch03.ex07;

import java.util.Comparator;

public class MyComparator {
	/*
	 * order true: 普通の順序 false: 逆順 
	 * camel true: 大文字小文字区別する false: 区別しない 
	 * space true: 空白を含める false: 含めない
	 */
	public static Comparator<String> stringComparator(boolean order, boolean camel, boolean space) {
		return (str1, str2) -> {
			if (!camel) {
				str1 = str1.toLowerCase();
				str2 = str2.toLowerCase();
			}
			if (!space) {
				str1 = str1.replaceAll(" ", "");
				str2 = str2.replaceAll(" ", "");
			}
			int result = str1.compareTo(str2);
			return order ? result: -1 * result ;
		};
	}

}
