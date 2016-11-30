package jpl.ch04.ex03;

/**リスト構造を保持するための一つのセル*/
public interface ListCell {
	/**LinkedListが保持しているデータを取得するもの*/
	public Object get();
	/**次のLinkedListを返す。なければnullを返す*/
	public ListCell next();
	/**nextを変更して、今までのnextを返す*/
	public ListCell setNext(ListCell newNext);
}
