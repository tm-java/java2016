package jpl.ch04.ex04;

public interface Queue<E> extends Collection<E> {
	boolean add(E e);
	E element();
	boolean offer(E e);
	E peek();
	E poll();
	E remove();
}
