package jpl.ch13.ex06;

public class InsertChar {
	public static String insertChar(String input, char insert,int btw){
		if(btw<=0) return input;
		
		StringBuffer reverse = new StringBuffer(input);
		StringBuffer newString = new StringBuffer();
		
		//反転
		reverse.reverse();
		
		//btw桁ごとにinsert
		for(int i=0;i<reverse.length();i++){
			newString.append(reverse.charAt(i));
			if((i+1)%btw==0) newString.append(insert);
		}
		return newString.reverse().toString();
		
	}

}
