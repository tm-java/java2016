package jpl.ch03.ex10;

import jpl.ch02.ex13.Vehicle;

public class LinkedList implements Cloneable{
	private Object data;
	private LinkedList next;

	final static int THREE = 3;
	
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
	
	//リスト内の要素を返すメソッド
	public int size(){
		int rtn=0;
		LinkedList l = this;
		while(l!=null){
			rtn++;
			l=l.next;
		}
		return rtn;
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
	
	public LinkedList clone(){
		/*LinkedList rtn = new LinkedList();//2017.1.6自分自身をnewしない
		//このクラスをfinalにするのであればokだけれども、これがサブクラスだとうまくいかない？
		//基本的に、cloneメソッドの中でnewはしない
		for(LinkedList l=getNext();l!=null;l=l.getNext()){
			LinkedList lCln = new LinkedList();
			lCln.next = rtn.next;
			rtn.next = lCln;
		}
		
		LinkedList l=getNext();
		LinkedList lcln = rtn.getNext();
		for(;l!=null;l=l.getNext(),lcln=lcln.getNext()){
			lcln.data = l.data; 
		}
		return rtn;
		*/
		
		//以下のコードは、練習問題としてはokだけど、製品としては制限かけなければならない
		//再帰はstackOverFlowが発生する可能性がある
		//スタックは、全部で1M、thread毎に1つのスタックだから、すぐ行ってしまう。面倒でも、forループで書くこと
		LinkedList rtn;
		try {
			rtn = (LinkedList) super.clone();
			if(next != null){
				rtn.next = (LinkedList) next.clone();
			}
			return rtn;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//先頭番地を示すヘッダー
		LinkedList head = new LinkedList();
		//Vehicleの配列
		Vehicle[] vcls = new Vehicle[THREE];
		
		for(int i=0;i<THREE;i++){
			//Vehicle型のデータ作成
			Vehicle v = new Vehicle("Mr."+i);
			v.setSpeed(100*i);
			v.setAngle(10*i);
			
			vcls[i] = v;
		}
		//配列をリスト構造にする
		head.makeList(head,vcls[0],vcls[1],vcls[2]);
		
		//clone
		LinkedList headCln = head.clone();
		
		//表示
		for(LinkedList l=head.getNext();l!=null;l=l.getNext()){
			System.out.println(l.getData().toString());
		}
		System.out.println();
		for(LinkedList l=headCln.getNext();l!=null;l=l.getNext()){
			System.out.println(l.getData().toString());
		}
		
		System.out.println();
		System.out.println("クローンのリスト変更");
		headCln.next.setData(vcls[0]);
		for(LinkedList l=head.getNext();l!=null;l=l.getNext()){
			System.out.println(l.getData().toString());
		}
		System.out.println();
		for(LinkedList l=headCln.getNext();l!=null;l=l.getNext()){
			System.out.println(l.getData().toString());
		}
		
		System.out.println();
		System.out.println("クローンの中のオブジェクト変更");
		vcls[0].setOwner("aaaaa");
		for(LinkedList l=head.getNext();l!=null;l=l.getNext()){
			System.out.println(l.getData().toString());
		}
		System.out.println();
		for(LinkedList l=headCln.getNext();l!=null;l=l.getNext()){
			System.out.println(l.getData().toString());
		}
		

	}

}
