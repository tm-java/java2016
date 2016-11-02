package jpl.ch01.ex16;

import java.io.IOException;

public class BadDataSetException extends Exception{

	private String name;
	private IOException ioe;
	
	public BadDataSetException(){
		super();
	}
	
	public BadDataSetException(String s, IOException e) {
		name = s;
		ioe = e;
	}
	
	
	public String getName(){
		return name;
	}
	
	public IOException getIOException(){
		return ioe;
	}
	
	
	/**詳細エラーの表示*/
	public void printError(){
		System.out.println("file name >> " + getName());
		System.out.println("error details >>");
		getIOException().printStackTrace();
		
	}
	
}
