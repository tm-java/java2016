package jpl.ch01.ex10;

/**フィボナッチ数列のn項とその値が偶数かを示すブール値を保持
 * n項を格納すると自動で隅奇も格納します*/
public class Term {
	private int termNum;	//n項の値
	private boolean isEven;//true:偶数 false:奇数
	
	public Term(int t){
		this.termNum = t;
		this.isEven = jadgeIsEven(t);
	}
	
	/**値が偶数か判断する*/
	public static boolean jadgeIsEven(int t){
		if(t % 2 == 0) return true;
		return false;
	}
	
	public void setTermNum(int t){
		this.termNum = t;
		this.isEven = jadgeIsEven(t);
	}
	
	public void setIsEven(boolean e){
		//何もしない
	}
	
	public int getTermNum(){
		return this.termNum;
	}
	
	public boolean getIsEven() {
		return this.isEven;
	}
	
	/**偶数なら"*"をつける*/
	@Override
	public String toString(){
		String rtn = "" + this.termNum;
		if(this.isEven) rtn+=" *";
		return rtn;
	}
}
