/**
 * dowhileに書き換えることが出来ない。
 * 必ず一回はループの内容が実行されるため、配列長が１の場合は
 * 実行時エラーになってしまう
 * */

package jpl.ch10.ex04;

import jpl.ch03.ex11.SortDouble;
import jpl.ch03.ex11.SortMetrics;

public class SimpleSortDoubleDoWhile extends SortDouble {
	@Override
	protected void doSort() {
		int i=0;
		do{
			int j=i+1;
			do{
				if(compare(i,j)>0){
					swap(i,j);
				}
				//配列の書き換えを行うわけではないが、不正にswapCntを稼ぐ可能性がある
				swap(i,i);
				swap(j,j);
				j++;
			}while(j<getDataLength()-1);
			i++;
		}while(i<getDataLength()-1);
	}
	
		
	public static void main(String[] args){
		double[] testData = {
				0.3, 1.3e-2, 7.9, 3.17
				//0.3　要素数１の配列にした場合、実行エラーが起きてしまう
		};
		
		SortDouble bsort = new SimpleSortDoubleDoWhile();
		SortMetrics metrics = bsort.sort(testData);
		System.out.println("Metrics: "+metrics);
		for(int i=0;i<testData.length;i++){
			System.out.println("\t" + testData[i]);
		}
	}


}
