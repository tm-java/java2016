package jpl.ch04.ex04;

import java.util.Comparator;

public interface SortedSet<E> extends Set<E> {
	Comparator <? super E> comparator();
	E first();
	SortedSet<E> deadSet(E toElement);
	E last();
	SortedSet<E> subSet(E fromElement, E toElement);
	SortedSet<E> tailSet(E fromElement);
}
