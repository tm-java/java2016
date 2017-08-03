package java8.ch03.ex23;

import java.util.function.Function;

public class Pair<T> {
	private T first;
	private T second;
	
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}
	
	public T getFirst() {
		return this.first;
	}
	
	public T getSecond() {
		return this.second;
	}
	
	public <U> Pair<U> map(Function<T, U> f) {
		return new Pair(f.apply(this.first), f.apply(this.second));
	}

}
