package jpl.ch04.ex03;

import jpl.ch03.ex07.ColorAttr;

public class TestLinkedListImpl {
	
	public static void testInt(){
		
		LinkedList list = new LinkedListImpl();
		
		list.add(0);
		list.add(1);
		list.add(2);
	
		System.out.println("list size : "+list.size());
		System.out.println(list);
		
		
		list.remove(1);
		System.out.println("list size : "+list.size());
		System.out.println(list);
		
		list.remove(1);
		System.out.println("list size : "+list.size());
		System.out.println(list);
		
		list.remove(0);
		System.out.println("list size : "+list.size());
		System.out.println(list);
		
		list.remove(2);
		System.out.println("list size : "+list.size());
		System.out.println(list);

	}
	
	public static void testColorAttr(){
		LinkedList list = new LinkedListImpl();
		
		list.add(new ColorAttr("RED","red"));
		list.add(new ColorAttr("GREEN","green"));
		list.add(new ColorAttr("no color"));
		
		System.out.println("list size : "+list.size());
		System.out.println(list);
		
		
		list.remove(new ColorAttr("GREEN","green"));
		System.out.println("list size : "+list.size());
		System.out.println(list);
		
		list.remove(new ColorAttr("GREEN","green"));
		System.out.println("list size : "+list.size());
		System.out.println(list);
		
		list.remove(new ColorAttr("RED","red"));
		System.out.println("list size : "+list.size());
		System.out.println(list);
		
		list.remove(new ColorAttr("no color"));
		System.out.println("list size : "+list.size());
		System.out.println(list);
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("***********test int**********");
		testInt();
		System.out.println("***********test ColorAttr**********");
		testColorAttr();
	}

}
