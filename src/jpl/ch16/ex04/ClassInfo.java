package jpl.ch16.ex04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ClassInfo {
	String created();
	String createdBy();
	String lastModified();
	String lastModifiedBy();
	Revision revision();
}
