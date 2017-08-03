package jpl.ch22.ex02;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WitchChars {
	private Map<Character, Boolean> used = new TreeMap<Character, Boolean>();

	public WitchChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			used.put(str.charAt(i), true);
		}
	}
	
	public String toString() {
		String desc = "[";
		for (Map.Entry<Character, Boolean> e : used.entrySet()) {
			desc += e.getKey();
		}
		return desc + "]";
	}

}
