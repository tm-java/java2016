package jpl.ch11.ex03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jpl.ch11.ex02.Attr;

public class AttributedImpl<E> implements Attributed<E>,Iterable<Attr<E>> {
	protected Map<String, Attr<E>> attrTable=new HashMap<String, Attr<E>>();

	@Override
	public void add(Attr<E> newAttr) {
		attrTable.put(newAttr.getName(), newAttr);
	}

	@Override
	public Attr<E> find(String attrName) {
		return attrTable.get(attrName);
	}

	@Override
	public Attr<E> remove(String attrName) {
		return attrTable.remove(attrName);
	}

	@Override
	public Iterator<Attr<E>> attrs() {
		return attrTable.values().iterator();
	}

	@Override
	public Iterator<Attr<E>> iterator() {
		return attrs();
	}

	public static void main(String[] args){
		AttributedImpl<String> at = new AttributedImpl<String>();
		at.add(new Attr<String>("a","aa"));
		at.add(new Attr<String>("b","1"));
		
		for(Attr<String> a:at){
			System.out.println(a.toString());
		}
		
	}
	
}
