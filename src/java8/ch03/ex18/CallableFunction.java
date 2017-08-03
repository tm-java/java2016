package java8.ch03.ex18;

@FunctionalInterface
public interface CallableFunction<T, R> {
	R applay(T t) throws Exception;
}
