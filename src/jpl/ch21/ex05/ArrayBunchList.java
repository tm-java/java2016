package jpl.ch21.ex05;

import java.util.AbstractList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class ArrayBunchList<E> extends AbstractList<E> {
	private E[][] arrays;
	private final int size;
	private final ListIterator<E> li;

	public ArrayBunchList(E[][] arrays) {
		this.arrays = arrays.clone();
		int s = 0;
		for (E[] array : arrays) {
			s += array.length;
		}
		size = s;
		li = new ABLListIterator();
	}

	@Override
	public E get(int index) {
		int off = 0;
		for (int i = 0; i < arrays.length; i++) {
			if (index < off + arrays[i].length) {
				return arrays[i][index - off];
			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}

	@Override
	public int size() {
		return size;
	}

	public E set(int index, E value) {
		int off = 0;
		for (int i = 0; i < arrays.length; i++) {
			if (index < off + arrays[i].length) {
				E ret = arrays[i][index - off];
				arrays[i][index - off] = value;
				return ret;
			}
			off += arrays[i].length;
		}
		throw new ArrayIndexOutOfBoundsException(index);
	}
	
	@Override
	public ListIterator<E> listIterator(){
		return li;
	}

	private class ABLListIterator implements ListIterator<E> {
		private int off;
		private int array;
		private int pos;
		
		private static final int NOTYET = 0;
		private static final int NEXT = 1;
		private static final int PREVIOUS = 2;
		private int ope;

		ABLListIterator() {
			off = 0;
			array = 0;
			pos = 0;
			for (array = 0; array < arrays.length; array++) {
				if (arrays[array].length > 0) {
					break;
				}
			}
			ope = NOTYET;
		}

		@Override
		public boolean hasNext() {
			return off + pos < size();
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E ret = arrays[array][pos++];

			while (pos >= arrays[array].length) {
				off += arrays[array++].length;
				pos = 0;
				if (array >= arrays.length) {
					break;
				}
			}
			ope = NEXT;
			return ret;
		}

		@Override
		public boolean hasPrevious() {
			return off + pos > 0;
		}

		@Override
		public E previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			pos--;
			while (pos < 0) {
				if (array <= 0) {
					break;
				}
				pos = arrays[--array].length - 1;
				off -= arrays[array].length;
			}
			E ret = arrays[array][pos];
			ope = PREVIOUS;
			return ret;
		}

		@Override
		public int nextIndex() {
			return off + pos;
		}

		@Override
		public int previousIndex() {
			return off + pos - 1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(E e) {
			if (ope == NOTYET) {
				throw new IllegalStateException();
			}
			int pos_ = pos;
			int array_ = array;
			int off_ = off;
			
			if (ope == NEXT) {
				pos_--;
				while (pos_ < 0) {
					if (array_ <= 0) {
						break;
					}
					pos_ = arrays[--array_].length - 1;
					off_ -= arrays[array_].length;
				}
				arrays[array_][pos_] = e;
			} else if (ope == PREVIOUS) {
				arrays[array][pos] = e;
			}
		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException();
		}

	}

}
