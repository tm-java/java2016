package jpl.ch07.ex01;


// 2/2 間違い。hello worldのみをユニコードとするのではなくて、
//このコード全体をユニコードを使って書きなさいってこと。
public class UnicodePractice {

	public static void main(String[] args) {
		
		System.out.print("\u0048");//H
		System.out.print("\u0065");//e
		System.out.print("\u006C");//l
		System.out.print("\u006C");//l
		System.out.print("\u006F");//o
		
		System.out.print("\u002C");//,
		
		System.out.print("\u0020");// 
		
		System.out.print("\u0057");//W
		System.out.print("\u006F");//o
		System.out.print("\u0072");//r
		System.out.print("\u006C");//l
		System.out.print("\u0064");//d
		
		//以下、ユニコード確認用
		//String helloworld = "Hello, World";
		//System.out.println(convertToUnicode(helloworld));
		
		

	}
	
	//インターネットのコードを参考
	//文字列をユニコードに変換するメソッド
	private static String convertToUnicode(String original){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<original.length();i++){
			sb.append(String.format("\\u%04X", Character.codePointAt(original,i)));
		}
		String unicode = sb.toString();
		return unicode;
		
	}

}
