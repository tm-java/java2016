package jpl.ch04.ex04;

import java.util.Iterator;

public interface Deque<E> extends Queue<E> {
	
	boolean add(E e);
	void addFirst(E e);
	void addLast(E e);
	boolean contains(Object o);
	Iterator<E> descendingIterator();
	E element();
	E getFirst();
	E getLast();
	Iterator<E> itarator();
	boolean offer(E e);
	boolean offerFirst();
	boolean offerLast();
	E peek();
	E peekFirst();
	E peekLast();
	E poll();
	E pollFirst();
	E pollLast();
	E pop();
	void push(E e);
	E remove();
	boolean remove(Object o);
	E removeFirst();
	boolean removeFirstOccurence(Object o);
	E removeLast();
	boolean removeLastOccurence(Object o);
	int size();

}
