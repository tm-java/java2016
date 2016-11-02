package jpl.ch02.ex11;

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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//先頭番地を示すヘッダー
		LinkedList head = new LinkedList();
			
		for(int i=0;i<FIVE;i++){
			//Vehicle型のデータ作成
			Vehicle v = new Vehicle("Mr."+i);
			v.speed=100*i;
			v.angle=10*i;
			
			//データの更新をして、新しいノードの作成
			LinkedList list = new LinkedList(v,head.next);
			head.next = list;
		}
		
		//表示
		for(LinkedList l=head.next;l!=null;l=l.next){
			System.out.println(l.toString());
		}

	}

	
}
