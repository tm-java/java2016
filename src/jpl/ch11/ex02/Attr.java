package jpl.ch11.ex02;

public class Attr<E> {
	private final String name;
	private E value = null;
	
	public Attr(String name){
		this.name = name;
	}
	
	public Attr(String name,E value){
		this.name = name;
		this.value = value;
	}
	
	public String getName(){
		return name;
	}
	
	public E getValue(){
		return value;
	}
	
	public E setValue(E newValue){
		E oldVal = value;
		value = newValue;
		return oldVal;
	}
	
	public String toString(){
		return name + " = '" + value.toString() + "'";
	}
	
	public static void main(String[] args){
		Attr<String> strAttr = new Attr<String>("a","aa");
		System.out.println(strAttr);
		
		Attr<Integer> intAttr = new Attr<Integer>("b",1);
		System.out.println(intAttr);
		
	}
}
