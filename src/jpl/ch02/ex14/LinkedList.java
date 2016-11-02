package jpl.ch02.ex14;

import jpl.ch02.ex13.Vehicle;

public class LinkedList {
	private Object data;
	private LinkedList next;

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
	
	//引数で受け取ったオブジェクトの配列をリスト構造にして、先頭の参照を返す
	public void makeList(LinkedList header,Object...objects){
		for(Object o:objects){
			LinkedList list = new LinkedList(o,header.next);
			header.next = list; 
		}
	}
	
	//セッター すべてのフィールドに対して変更可能
	public void setData(Object o){
		this.data = o;
	}
	
	public void setNext(LinkedList l){
		this.next = l;
	}
	
	//ゲッター　すべてのフィールドに対してアクセス可能
	public Object getData(){
		return this.data;
	}
	
	public LinkedList getNext(){
		return this.next;
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
			v.setSpeed(100*i);
			v.setAngle(10*i);
			
			vcls[i] = v;
		}
		//配列をリスト構造にする
		head.makeList(head,vcls[0],vcls[1],vcls[2],vcls[3],vcls[4]);
		
		//表示
		for(LinkedList l=head.getNext();l!=null;l=l.getNext()){
			Vehicle v = (Vehicle)l.getData();
			System.out.println(v.toString());
		}

	}

}
