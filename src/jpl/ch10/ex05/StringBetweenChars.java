package jpl.ch10.ex05;

public class StringBetweenChars {
	
	public static void showStringBetweenChars(char c1,char c2){
		if(c1 > c2){
			char tmp = c1;
			c1 = c2;
			c2 = tmp;
		}
		
		for(char c = c1;c<=c2;c++){
			System.out.print(c);
		}
		System.out.println();
	}
	
	public static void main(String []args){
		StringBetweenChars.showStringBetweenChars('a', 'z');
		StringBetweenChars.showStringBetweenChars('0', 'b');
	}

}
