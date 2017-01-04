package jpl.ch10.ex04;

import jpl.ch03.ex11.SortDouble;
import jpl.ch03.ex11.SortMetrics;

public class SimpleSortDoubleWhile extends SortDouble {
	@Override
	protected void doSort() {
		int i=0;
		while(i<getDataLength()){
			int j=i+1;
			while(j<getDataLength()){
				if(compare(i,j)>0){
					swap(i,j);
				}
				//配列の書き換えを行うわけではないが、不正にswapCntを稼ぐ可能性がある
				swap(i,i);
				swap(j,j);
				j++;
			}
			i++;
		}
	}
	
		
	public static void main(String[] args){
		double[] testData = {
				0.3, 1.3e-2, 7.9, 3.17
				//0.3
		};
		
		SortDouble bsort = new SimpleSortDoubleWhile();
		SortMetrics metrics = bsort.sort(testData);
		System.out.println("Metrics: "+metrics);
		for(int i=0;i<testData.length;i++){
			System.out.println("\t" + testData[i]);
		}
	}

}
