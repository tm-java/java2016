package jpl.ch16.ex05;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.LinkedHashSet;
import java.util.Set;

//java.lang.Deprecatedが、リテンションポリシーがRUNTIMEになっている

public class ClassContents {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(mergeMembers(c.getFields(), c.getDeclaredFields()));
			printMembers(mergeMembers(c.getConstructors(), c.getDeclaredConstructors()));
			printMembers(mergeMembers(c.getMethods(), c.getDeclaredMethods()));
			printAnnotations(c.getAnnotations());
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class:" + args[0]);
		}
	}

	private static void printMembers(Member[] mems) {
		if (mems == null) {
			return;
		}
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
		if (mem1 == null) {
			return null;
		}
		
		Set<Member> set = new LinkedHashSet<Member>();
		for (Member m : mem1) {
			set.add(m);
		}

		for (Member m : mem2) {
			set.add(m);
		}

		return set.toArray(new Member[0]);
	}

	private static void printAnnotations(Annotation[] ann) {
		if (ann == null) {
			return;
		}

		for (Annotation a : ann) {
			System.out.print(" ");
			System.out.println(a.toString());
		}
	}

	private static String strip(String str, String del) {
		return str.replaceAll(del, "");
	}
}
