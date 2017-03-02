package jpl.ch16.ex04;

import java.lang.annotation.Annotation;

@ClassInfo(
	created = "Fab 26 2017",
	createdBy = "tm",
	lastModified = "Fab 26 2017",
	lastModifiedBy = "tm",
	revision = @Revision(major = 1))
public class AnnotationContents {
	public static void main(String[] args) {
		AnnotationContents ac = new AnnotationContents();
		Class<?> acls = ac.getClass();
		System.out.println(acls);
		printAnnotations(acls.getAnnotations());
	}

	private static void printAnnotations(Annotation[] ann) {
		for (Annotation a : ann) {
			System.out.print(" ");
			System.out.print(a.toString());
		}
	}
}
