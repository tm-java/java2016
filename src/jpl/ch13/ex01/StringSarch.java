package jpl.ch13.ex01;

public class StringSarch {
	
	public static int countChar(String str, char ch){
		int count=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==ch) count++;
		}
		return count;
	}

}
