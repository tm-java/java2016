package jpl.ch02.ex08;

import jpl.ch02.ex07.Vehicle;

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
			//新しいコンストラクタを使用するに当たって、ヘッダーを準備する
			//次のデータはリストの先頭に追加していく（常にヘッダーの次を更新していく）
			LinkedList list = new LinkedList(v,head.next);
			head.next = list;
		}
		
		//表示
		for(LinkedList l=head.next;l!=null;l=l.next){
			Vehicle v = (Vehicle)l.data;
			System.out.print("ID : " + v.ID);
			System.out.println(" ["+v.speed + "km/h, "+v.angle+"Cº, "+v.owner+"]");
		}

	}

}
