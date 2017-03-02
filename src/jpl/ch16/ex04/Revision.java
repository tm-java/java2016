package jpl.ch16.ex04;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Revision {
	int major() default 1;

	int minor() default 0;
}
