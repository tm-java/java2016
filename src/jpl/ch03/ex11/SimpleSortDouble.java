package jpl.ch03.ex11;

public class SimpleSortDouble extends SortDouble {

	@Override
	protected void doSort() {
		for(int i=0;i<getDataLength();i++){
			for(int j=i+1;j<getDataLength();j++){
				if(compare(i,j)>0){
					swap(i,j);
				}
				//配列の書き換えを行うわけではないが、不正にswapCntを稼ぐ可能性がある
				swap(i,i);
				swap(j,j);
			}
		}

	}

}
