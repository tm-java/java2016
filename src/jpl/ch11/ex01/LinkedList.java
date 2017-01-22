package jpl.ch11.ex01;

public class LinkedList<E> {
	private E data;
	private LinkedList<E> next;
	
	public LinkedList(){}
	
	public LinkedList(E d){
		this.data = d;
	}
	
	public LinkedList(E d, LinkedList<E> n){
		this(d);
		this.next = n;
	}
	
	@Override
	public String toString(){
		return this.data.toString();
	}
	
	public void setData(E d){
		this.data = d;
	}
	
	public E getData(){
		return this.data;
	}
	
	public void setNext(LinkedList<E> n){
		this.next = n;
	}
	
	public LinkedList<E> getNext(){
		return this.next;
	}
	
	public static void main(String[] args){
		LinkedList<Integer> header = new LinkedList<Integer>();
		for(int i=0;i<10;i++){
			LinkedList<Integer> cell = new LinkedList<Integer>(i,header.getNext());
			header.setNext(cell);
		}
		
		for(LinkedList<Integer> itr = header.getNext();itr!=null;itr=itr.getNext()){
			System.out.println(itr.toString());
		}
		
		//下の２文はコンパイルエラー
		//header.setNext(new LinkedList<Number>());
		//header.setData("aaa");
		
	}
	
	
	
}
