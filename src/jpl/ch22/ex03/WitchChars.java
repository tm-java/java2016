package jpl.ch22.ex03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class WitchChars {
	private HashMap<Integer, BitSet> used = new HashMap<Integer, BitSet>();

	public WitchChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			int c = str.charAt(i);
			int key = (c >> 8);
			BitSet value;
			if (used.containsKey(key)) {
				value = used.get(key);
			} else {
				value = new BitSet();
			}
			value.set(c & 0x00ff);
			used.put(key, value);
		}
	}

	public String toString() {
		String desc = "[";
		for (Map.Entry<Integer, BitSet> e : used.entrySet()) {
			int key = e.getKey();
			BitSet value = e.getValue();
			for (int i = value.nextSetBit(0); i >= 0; i = value.nextSetBit(i + 1)) {
				desc += (char) ((key << 8) | i);
			}
		}
		return desc + "]";
	}

}
