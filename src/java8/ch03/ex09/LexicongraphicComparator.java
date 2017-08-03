package java8.ch03.ex09;

import java.lang.reflect.Field;
import java.util.Comparator;

public class LexicongraphicComparator {
	public static Comparator<?> lexicongraphicComaparator(String...fieldNames) {
		return (f, s) -> {
			for (String name : fieldNames) {
				Object fo, so;
				try {
					fo = getField(f, name);
					so = getField(s, name);
					if (!fo.equals(so)) {
						return ((Comparable)fo).compareTo(so);
					}
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			return 0;
		};
	}
	
	public static Object getField(Object o, String field) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field f = o.getClass().getDeclaredField(field);
		f.setAccessible(true);
		return f.get(o);
	}

}
