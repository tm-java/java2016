package jpl.ch02.ex16;

import jpl.ch02.ex13.Vehicle;

/**
 * 値(Object)と次のLinkedList(next)を持つLinkedList
 * 
 * @author matsuitomomi
 *
 */
public class LinkedList {

	/**
	 * リストの値を表す 初期値はnull
	 */
	private Object data;
	/**
	 * リストの次を表す 初期値はnull
	 */
	private LinkedList next;

	/**
	 * main関数内で使用した定数
	 * @deprecated
	 */
	final static int FIVE = 5;

	/**
	 * 空のLinkedListを作成
	 */
	public LinkedList() {
	}

	/**
	 * 指定されたdataと、nextをセットした新たなLinkedListを作成
	 * 
	 * @param d
	 *            dataにセットするオブジェクト
	 * @param n
	 *            nextにセットするLinkedList
	 */
	public LinkedList(Object d, LinkedList n) {
		data = d;
		next = n;
	}

	/**
	 * dataのtoStringを返す
	 * 
	 * @return String dataの値
	 */
	@Override
	public String toString() {
		return data.toString();
	}

	/**
	 * 指定されたリストの先頭から順に、オブジェクトの可変長引数をリスト構造に変換する
	 * 
	 * @param header
	 *            リストの先頭
	 * @param objects
	 *            リストに格納したいオブジェクトの可変長引数
	 */
	public void makeList(LinkedList header, Object... objects) {
		for (Object o : objects) {
			LinkedList list = new LinkedList(o, header.next);
			header.next = list;
		}
	}

	/**
	 * このLinkedListの後ろにつながっているLinkedListの数を返す (このLinkedListも数に含む)
	 * 
	 * @return 後ろにつながっているLinkedListの数
	 */
	public int size() {
		int rtn = 0;
		LinkedList l = this;
		while (l != null) {
			rtn++;
			l = l.next;
		}
		return rtn;
	}

	/**
	 * セッター
	 * 
	 * @param o
	 *            dataにセットしたいオブジェクト
	 */
	public void setData(Object o) {
		this.data = o;
	}

	/**
	 * セッター
	 * 
	 * @param l
	 *            nextにセットしたいLinkedList
	 */
	public void setNext(LinkedList l) {
		this.next = l;
	}

	/**
	 * ゲッター
	 * 
	 * @return dataのオブジェクト
	 */
	public Object getData() {
		return this.data;
	}

	/**
	 * ゲッター
	 * 
	 * @return nextのLinkedList
	 */
	public LinkedList getNext() {
		return this.next;
	}

	/**
	 * LinkedListの操作のために作成
	 * @param args
	 * @deprecated
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 先頭番地を示すヘッダー
		LinkedList head = new LinkedList();
		// Vehicleの配列
		Vehicle[] vcls = new Vehicle[FIVE];

		for (int i = 0; i < FIVE; i++) {
			// Vehicle型のデータ作成
			Vehicle v = new Vehicle("Mr." + i);
			v.setSpeed(100 * i);
			v.setAngle(10 * i);

			vcls[i] = v;
		}
		// 配列をリスト構造にする
		head.makeList(head, vcls[0], vcls[1], vcls[2], vcls[3], vcls[4]);

		// 表示
		System.out.println(head.getNext().size());
		for (LinkedList l = head.getNext(); l != null; l = l.getNext()) {
			Vehicle v = (Vehicle) l.getData();
			System.out.println(v.toString());
		}

	}

}
