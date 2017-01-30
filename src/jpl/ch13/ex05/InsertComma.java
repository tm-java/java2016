package jpl.ch13.ex05;

public class InsertComma {
	public static String insertComma(String input){
		int comma = 3;
		StringBuffer reverse = new StringBuffer(input);
		StringBuffer newString = new StringBuffer();
		
		//反転
		reverse.reverse();
		
		//3桁ごとにカンマ
		for(int i=0;i<reverse.length();i++){
			newString.append(reverse.charAt(i));
			if((i+1)%comma==0) newString.append(",");
		}
		return newString.reverse().toString();
		
	}
}
