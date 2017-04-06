package jpl.ch17.ex01;

import java.util.LinkedList;
import java.util.List;

public class CheckMemory {

	private List makeLotsObject(int size) {
		List objects = new LinkedList();
		for (int l = 0 ; l < size ; l++) {
			objects.add(new Object());
			objects.add(new LinkedList(objects));
		}
		return objects;
	}
	
	private void showFreeMemory() {
		System.out.println("free memory is " + Runtime.getRuntime().freeMemory());
	}

	public static void main(String[] args) {
		CheckMemory cm = new CheckMemory();
		int size = 2500;
		System.out.println("size : " + size);
		System.out.println("make a lot of Object");
		List list = cm.makeLotsObject(size);
		cm.showFreeMemory();
		System.out.println("do unreachable");
		list = null;
		System.out.println("do gc");
		Runtime.getRuntime().gc();
		cm.showFreeMemory();	
	}

}
