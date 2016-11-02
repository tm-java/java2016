/**練習2.12:Vehicleクラスに可変長の引数を持つメソッドは必要ない
 * 【理由】Vehicleクラスは速度、角度、持ち主、識別番号のシンプルなフィールドしか持っていないため、
 * 固定の引数で対応可能であるから
 * 
 * LinkedListは、与えられた可変長のオブジェクトの引数をリスト構造にして返すメソッドの需要はある*/

package jpl.ch02.ex12;

import jpl.ch02.ex10.Vehicle;

public class LinkedList {
	public Object data;
	public LinkedList next;

	final static int FIVE = 5;
	
	public LinkedList(){
	}
	
	public LinkedList(Object d, LinkedList n){
		data = d;
		next = n;
	}
	
	@Override
	public String toString(){
		return data.toString();
	}
	
	//引数で受け取ったオブジェクトの配列をリスト構造にする
	public void makeList(LinkedList header,Object...objects){
		for(Object o:objects){
			LinkedList list = new LinkedList(o,header.next);
			header.next = list; 
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//先頭番地を示すヘッダー
		LinkedList head = new LinkedList();
		//Vehicleの配列
		Vehicle[] vcls = new Vehicle[FIVE];
		
		for(int i=0;i<FIVE;i++){
			//Vehicle型のデータ作成
			Vehicle v = new Vehicle("Mr."+i);
			v.speed=100*i;
			v.angle=10*i;
			
			vcls[i] = v;
		}
		//配列をリスト構造にする
		head.makeList(head,vcls[0],vcls[1],vcls[2],vcls[3],vcls[4]);
		
		//表示
		for(LinkedList l=head.next;l!=null;l=l.next){
			System.out.println(l.toString());
		}

	}

}
