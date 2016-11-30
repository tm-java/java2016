package jpl.ch04.ex03;

public class LinkedListImpl implements LinkedList {

	private ListCell head;
	private long size;
	
	public LinkedListImpl(){
		head = new ListCellImpl(null,null);
		size = 0;
	}
	
	/**リストのサイズを返す*/
	@Override
	public long size(){
		return size;
	}
	
	/**リストにデータを追加する */
	@Override
	public void add(Object o){
		ListCell added = new ListCellImpl(o,head.next());
		head.setNext(added);
		size++;
	}
	
	/**リスト内にoと同値の最初のListCellを見つける
	 * その一つ前のListCellを返す*/
	private final ListCell serch(Object o){
		ListCell pre = head;
		for(ListCell l = head.next();l!=null;l=l.next()){
			if(l.equals(o)) return pre;
			pre = l;
		}
		return null;
	}
	
	/**リスト内のオブジェクトを削除する*/
	@Override
	public boolean remove(Object o){
		ListCell serch = serch(o);
		if(serch==null) return false;
		
		serch.setNext(serch.next().next());
		size--;
		return true;
	}
	
	public String toString(){
		String rtn = "";
		for(ListCell l = head.next();l!=null;l=l.next()){
			rtn += l.toString();
			rtn += "\n";
		}
		return rtn;
	}
	
}
