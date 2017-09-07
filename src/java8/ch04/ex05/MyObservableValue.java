package java8.ch04.ex05;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class MyObservableValue {
	public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
		return Bindings.createObjectBinding(() -> f.apply(t.getValue()), t);
	}
	
	public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
		return Bindings.createObjectBinding(() -> f.apply(t.getValue(), u.getValue()), t, u);
	}

}
