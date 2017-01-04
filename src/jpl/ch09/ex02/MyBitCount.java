package jpl.ch09.ex02;

public class MyBitCount {
	
	static public int myBitCount(int val){
		int count=0;
		while(val!=0){
			if((0x1 & val)==1){
				count++;
			}
			val=val>>>1;
		}
		return count;
	}
	
	/**Integer.bitCount*/
	public static int bitCount(int x) {
		x = ((x >> 1) & 0x55555555) + (x & 0x55555555);
		x = ((x >> 2) & 0x33333333) + (x & 0x33333333);
		x = ((x >> 4) & 0x0f0f0f0f) + (x & 0x0f0f0f0f);
		x = ((x >> 8) & 0x00ff00ff) + (x & 0x00ff00ff);
		
		return ((x >> 16) & 0x0000ffff) + (x & 0x0000ffff);
	}
	//比較：計算時間が違う。MyBitCountはO(n)、Integer.bitCountはO(1)
	
	public static void main(String[] args) {
		System.out.println("myBitCount(1) \t\t:" + myBitCount(1));
		System.out.println("Integer.bitCount(1) \t:" + Integer.bitCount(1));
		
		System.out.println("myBitCount(-1) \t\t:" + myBitCount(-1));
		System.out.println("Integer.bitCount(-1) \t:" + Integer.bitCount(-1));
		
		System.out.println("myBitCount(255) \t:" + myBitCount(255));
		System.out.println("Integer.bitCount(255) \t:" + Integer.bitCount(255));
	}

}
