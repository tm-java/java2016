package jpl.ch22.ex04;

public interface Attributed {
	void add(Library.Book newBook);
	Library.Book find(String attrName);
	Library.Book remove(String attrName);
	java.util.Iterator<Library.Book> attrs();
}
