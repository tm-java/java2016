package jpl.ch21.ex07;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public final class ArrayListStack<E> {
	private final List<E> fifo;

	public ArrayListStack() {
		fifo = new ArrayList<E>();
	}

	public E push(E item) {
		fifo.add(0, item);
		return item;
	}
	
	public E pop() {
		E rtn = peek();
		fifo.remove(0);
		return rtn;
	}
	
	public E peek() {
		if (fifo.isEmpty()) {
			throw new EmptyStackException();
		}
		return fifo.get(0);
	}

	public boolean empty() {
		return fifo.isEmpty();
	}

	public int search(Object c) {
		for (int i = 0; i < fifo.size(); i++) {
			if ((fifo.get(i)).equals(c)) {
				return i + 1;
			}
		}
		return -1;
	}

}
