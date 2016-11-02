package jpl.ch02.ex06;

import jpl.ch02.ex03.Vehicle;

public class LinkedList {
	public Object data;
	public LinkedList next;

	final static int FIVE = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList list = new LinkedList();
		LinkedList head = list;
			
		for(int i=0;i<FIVE;i++){
			//Vehicle型のデータ作成
			Vehicle v = new Vehicle();
			v.speed=100*i;
			v.angle=10*i;
			v.owner="Mr."+i;
			v.ID=Vehicle.nextID;
			Vehicle.nextID++;
			
			//データの更新をして、新しいノードの作成
			list.data = v;
			if((i+1)<FIVE) {
				list.next = new LinkedList();
			}
			list = list.next;
		}
		
		//表示
		for(LinkedList l=head;l!=null;l=l.next){
			Vehicle v = (Vehicle)l.data;
			System.out.print("ID : " + v.ID);
			System.out.println(" ["+v.speed + "km/h, "+v.angle+"Cº, "+v.owner+"]");
		}

	}

}
