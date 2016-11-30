package jpl.ch04.ex03;

/**リスト構造を構成するListCellを管理する*/
public interface LinkedList {
	/**リストのサイズを返す*/
	public long size();
	/**リストにデータを追加する */
	public void add(Object o);
	/**リストの中で、存在するならば、初めて出てきたoを削除する　return true
	 * なければ return false*/
	public boolean remove(Object o);
}
