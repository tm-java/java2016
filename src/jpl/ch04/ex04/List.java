package jpl.ch04.ex04;

import java.util.Iterator;
import java.util.ListIterator;

/**順序付けされたコレクション。重複する要素を許可します*/
public interface List<E> extends Collection<E> {
	
	/**指定された要素がこのリストに格納されていることを保証します*/
	boolean add(E e);
	/**このリスト内の指定された位置に、指定された要素を挿入します*/
	void add(int index, E element);
	/**指定されたコレクションのすべての要素をこのリストに追加します（オプションの操作）*/
	boolean addALL(Collection<? extends E> c);
	/**指定されたコレクション内のすべての要素を、このリストの指定された位置に挿入します*/
	boolean addALL(int index, Collection<? extends E> c);
	/**このリストからすべての要素を削除します*/
	void clear();
	/**指定された要素がリストに含まれている場合にtrueを返します*/
	boolean contains(Object o);
	/**指定されたコレクションのすべての要素がこのリスト内にある場合はtrueを返します*/
	boolean containsALL(Collection<?> c);
	/**指定されたオブジェクトとこのリストが等しいかどうかを比較します*/
	boolean equals(Object o);
	/**このリスト内の指定された位置にある要素を返します*/
	E get(int index);
	/**リストのハッシュコード値を返します*/
	int hashCode();
	/**指定された要素がこのリスト内で最初に検出された位置のインデックスを返します
	 * 指定された要素がこのリストにない場合は、-1を返します*/
	int indexOf(Object o);
	/**このリストに要素がない場合にtrueを返します*/
	boolean isEmpty();
	/**リストの要素のイテレータを返します*/
	Iterator<E> iterator();
	/**指定された要素がこのリスト内で最後に検出された位置のインデックスを返します
	 * 指定された要素がこのリストにない場合は、-1を返します*/
	int lastIndexOf(Object o);
	/**このリスト内の要素を（適切な順序で）反復するリストイテレータを返します*/
	ListIterator<E> listIterator();
	/**このリスト内の指定された位置で始まる、
	 * リスト内の要素を（適切な順序で）反復するリストイテレータを返します*/
	ListIterator<E> listIterator(int index);
	/**指定された要素のインスタンスがこのリストにあれば、
	 * そのインスタンスをリストから１つ削除します*/
	boolean remove(Object o);
	/**このリスト内の指定された位置にある要素を削除します*/
	boolean remove(int index);
	/**指定されたコレクションにも格納されているこのリストのすべての要素を削除します*/
	boolean removeALL(Collection<?> c);
	/**このリスト内で、指定されたコレクションに含まれている要素だけを保持します*/
	boolean retainAll(Collection<?> c);
	/**このリスト内の指令された位置にある要素を、指定された要素に置き換えます*/
	E set(int index,E element);
	/**このリスト中の要素の数を返します*/
	int size();
	/**このリストの、指定されたfromIndex（これを含む）から、
	 * toIndex（これを含む）までの部分のビューを返します*/
	List<E> sublist(int fromIndex, int toIndex);
	/**このリストの要素がすべて格納されている配列を返します*/
	Object[] toArray();
	/**このリストないのすべての要素を保持する配列を返します
	 * 返される配列の実行時の型は、指定された配列の型です*/
	<T> T[] toArray(T[] a); 

}
