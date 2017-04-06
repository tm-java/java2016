package jpl.ch19.ex01;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jpl.ch02.ex16.LinkedList;

/**
 * 
 * @author Yoshikazu Murase
 *
 */
public class LinkedListSample {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		LinkedList second = new LinkedList(Color.yellow, null);
		LinkedList first = new LinkedList(Color.black, second);
		
		System.out.println("リストのサイズは"+first.size()+"です。");
		
		LinkedList current = first;
		for(int i=0; i<first.size(); i++){
			System.out.println("現在の色は"+((Color)current.getData()).toString()+"です。");
			current = current.getNext();
		}	
	}
}
