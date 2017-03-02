package jpl.ch16.ex03;

import java.lang.reflect.Member;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClassContents {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(mergeMembers(c.getFields(),c.getDeclaredFields()));
			printMembers(mergeMembers(c.getConstructors(),c.getDeclaredConstructors()));
			printMembers(mergeMembers(c.getMethods(),c.getDeclaredMethods()));
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class:" + args[0]);
		}
	}

	private static void printMembers(Member[] mems) {
		for (Member m : mems) {
			if (m.getDeclaringClass() == Object.class) {
				continue;
			}
			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl, "java.lang."));

		}
	}

	private static Member[] mergeMembers(Member[] mem1, Member[] mem2) {
		Set<Member> set = new LinkedHashSet<Member>();
		for (Member m : mem1) {
			set.add(m);
		}

		for (Member m : mem2) {
			set.add(m);
		}
		
		return set.toArray(new Member[0]);
	}

	private static String strip(String str, String del) {
		return str.replaceAll(del, "");
	}
}
