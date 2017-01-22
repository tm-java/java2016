package jpl.ch03.ex12;

//2017.1.6これは、なんか違う。前のCompareCntとかのやつを実装をしなきゃいけない

public class SortHarness {
	static <T extends Comparable<T>> T[] sort(T[] list){
		
		for(int i=0;i<list.length;i++){
			for(int j=list.length-1; j>i; j--){
				if(list[j-1].compareTo(list[j])>0) {
					//swap
					T swap = list[j];
					list[j] = list[j-1];
					list[j-1] = swap;
				}
			}
		}
		
		return list;
	}
	
}
