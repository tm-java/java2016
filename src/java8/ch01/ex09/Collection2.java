package java8.ch01.ex09;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface Collection2<E> extends Collection<E> {
	default void forEachIf(Consumer<E> action, Predicate<E> filter) {
		Objects.requireNonNull(action);
        for (E e : this) {
        	if (filter.test(e)) {
        		action.accept(e);
        	}
        }
	}
}
