package jpl.ch13.ex02;

public class StringSarch {
	public static int countSubString(String str, String sub){
		int count = 0;
		int subLength = sub.length();
		
		for(int i=0;i<(str.length()-subLength+1);i++){
			if(sub.equals(str.substring(i, i+subLength))) count++;
		}
		return count;
	}
	
}
