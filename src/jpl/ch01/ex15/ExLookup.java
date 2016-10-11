package jpl.ch01.ex15;

public interface ExLookup extends Lookup{

	/**nameと関連づけされた値がなければ追加する*/
	void add(String name, Object obj);
	
	/**nameに関連付けされた値を削除する*/
	void remove(String name);
}
