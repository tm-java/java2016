package jpl.ch03.ex11;

//不正させるポイント！！ソートして、実際の計算回数よりいい値に見せたい
public class SimpleSortDouble extends SortDouble {

	@Override
	protected void doSort() {
		for(int i=0;i<getDataLength();i++){
			for(int j=i+1;j<getDataLength();j++){
				if(compare(i,j)>0){
					swap(i,j);
				}
				//配列の書き換えを行うわけではないが、不正にswapCntを稼ぐ可能性がある
				//2017.1.6これは、ただ数を増やしているだけなので、正しい値ではないけど、
				//アルゴリズムをよく見せようという不正ではない
				swap(i,i);
				swap(j,j);
				
				//不正１
				//2017.1.6 長さ0の配列でソートし直すことで、これまでのメトリクスを初期化できてしまう
				/*if(getDataLength() != 0){
					super.sort(new double[0]);
				}*/
				
				//不正２（でも不可能。intならできる）
				//メトリクスをオーバーフローさせる。ソートした後で、無意味にswapを呼び出して
				//CompareCntを0に戻せば、不正ができる。ただし、その処理を終わらせるのに、200年くらいかかる
				//つまり、longを常識の範囲時間でオーバーフローさせるのは無理
				
				//不正３
				//probe()を使えば、すべての配列をとってこれる。そうすると、compare()を一度も使わずに、ソートができる
			}
		}

	}

}
