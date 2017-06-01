package jpl.ch24.ex01;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class GlobalRes_ja_JP extends ResourceBundle {
	Hashtable<String,String> table = new Hashtable<String, String>();
	
	public GlobalRes_ja_JP() {
		super();
		table.put("HELLO", "こんにちは");
		table.put("GOODBYE", "さようなら");
	}
	

	@Override
	protected Object handleGetObject(String key) {
		return table.get(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return table.keys();
	}

}
