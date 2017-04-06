package jpl.ch11.ex03;

import jpl.ch11.ex02.Attr;

public interface Attributed<E> {
	void add (Attr<E> newAttr);
	Attr<E> find (String attrName);
	Attr<E> remove(String attrName);
	java.util.Iterator<Attr<E>> attrs();

}

/*
 * public interface Attributed {
	void add (Attr<Object> newAttr);
	Attr find (String attrName);
	Attr remove(String attrName);
	java.util.Iterator<Attr> attrs();
}

こういう風にしてもいい
 */
