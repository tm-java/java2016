package jpl.ch22.ex12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

public class AttributedImpl implements Attributed, Iterable<Attr> {
	private Map<String, Attr> table = new HashMap<String, Attr>();
	
	@Override
	public void add(Attr newAttr) {
		table.put(newAttr.getName(), newAttr);
	}

	@Override
	public Attr find(String name) {
		return table.get(name);
	}

	@Override
	public Attr remove(String name) {
		return table.remove(name);
	}

	@Override
	public Iterator<Attr> attrs() {
		return table.values().iterator();
	}

	@Override
	public Iterator<Attr> iterator() {
		return attrs();
	}

}
