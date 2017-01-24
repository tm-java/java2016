package jpl.ch12.ex01;

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
	
	public LinkedList<E> find(E d)throws ObjectNotFoundException{
		for(LinkedList<E> l=next;l!=null;l=l.next){
			if(l.getData().equals(d)) return l;
		}
		throw new ObjectNotFoundException();
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
		
		
		try {
			System.out.println(header.find(1).toString());
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(header.find(11).toString());
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}