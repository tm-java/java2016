package jpl.ch22.ex13;

public interface Attributed {
	void add(Attr newBook);
	Attr find(String attrName);
	Attr remove(String attrName);
	java.util.Iterator<Attr> attrs();
}
