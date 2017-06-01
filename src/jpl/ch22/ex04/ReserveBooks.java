package jpl.ch22.ex04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class ReserveBooks implements Attributed, Iterable<Library.Book> {
	private Map<String, Library.Book> reserve = new HashMap<String, Library.Book>();
	
	@Override
	public void add(Library.Book newBook) {
		reserve.put(newBook.getName(), newBook);
	}

	@Override
	public Library.Book find(String name) {
		return reserve.get(name);
	}

	@Override
	public Library.Book remove(String name) {
		return reserve.remove(name);
	}

	@Override
	public Iterator<Library.Book> attrs() {
		return reserve.values().iterator();
	}

	@Override
	public Iterator<Library.Book> iterator() {
		return attrs();
	}

}

