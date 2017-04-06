/**
 * 3 << 2L -1	-> int 6
 * (3L << 2) -1		-> long 11
 * 10 < 12 == 6 > 17 	-> boolean false
 * 10 << 12 == 6 >> 17	-> boolean false
 * 13.5e-1 % Float.POSITIVE_INFINITY	-> double 13.5e-1 
 * Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY	-> Double NaN
 * Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY	-> Double POSITIVE_INFINITY
 * 0.0 / -0.0 == -0.0 / 0.0		-> boolean false
 * Integer.MAX_VALUE + Integer.MIN_VALUE	-> Integer 0
 * Long.MAX_VALUE + 5		-> 正しくない
 * (short) 5 * (byte) 10	-> short 50
 * (i < 15 ? 1.72e3f : 0)	-> double 1.72e3f or 0.0
 * i++ + i++ + --i  //iは3	-> int 11
 * */


package jpl.ch09.ex04;

public class CodeJudge {
	//2/2追加 judgeType
	private String judgeType(byte b) {
		return "byte";
	}
	
	private String judgeType(short s) {
		return "short";
	}
	
	private String judgeType(char c) {
		return "char";
	}
	
	private String judgeType(int i) {
		return "int";
	}
	
	private String judgeType(long l) {
		return "long";
	}
	
	private String judgeType(float f) {
		return "float";
	}
	
	private String judgeType(double d) {
		return "double";
	}
	
	private String judgeType(boolean b) {
		return "boolean";
	}
	
	public static void main(String [] args){
		int i = 3;
		 System.out.println(3 << 2L -1);//-> int 6
		 System.out.println((3L << 2) -1);//-> long 11
		 System.out.println(10 < 12 == 6 > 17);//-> boolean false
		 System.out.println(10 << 12 == 6 >> 17);//	-> boolean false
		 System.out.println(13.5e-1 % Float.POSITIVE_INFINITY);//-> double 13.5e-1 
		 System.out.println(Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);//-> Double NaN
		 System.out.println(Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY);//-> Double POSITIVE_INFINITY
		 System.out.println(0.0 / -0.0 == -0.0 / 0.0);//-> boolean false
		 System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);//-> Integer 0　2/2追記。実際はIntegerの-1
		 System.out.println(Long.MAX_VALUE + 5);//-> 正しくない	2/2追記。 Long マイナス行って、ぐるっといく数値
		 System.out.println((short) 5 * (byte) 10);//-> short 50 2/2追記。 int　全部int型に格上げ
		 System.out.println((i < 15 ? 1.72e3f : 0));//-> double 1.72e3f or 0.0  2/2追記。 float
		 System.out.println(i++ + i++ + --i);  //iは3-> int 11
		 
		 // 2/2 
	}

}
