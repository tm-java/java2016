package jpl.ch13.ex03;

import java.util.ArrayList;
import java.util.List;

public class DelimitedString {
	public static String[] delimitedString(String from, char start, char end){
		int startPos = from.indexOf(start);
		if(startPos == -1) return null;	//開始文字がない場合はnull
		
		int endPos = from.indexOf(end,startPos);
		List<String> returnList = new ArrayList<String>();	//格納用リスト
		
		while(startPos != -1){	//開始文字が見つかるたびに、その後にあるすべての終了文字を検索する
			int size = returnList.size();
			while(endPos != -1){
				returnList.add(from.substring(startPos, endPos+1));
				endPos = from.indexOf(end,endPos+1);
			}
			//終了文字が見つからなければ、最後までの部分文字列を追加
			if(size == returnList.size()) returnList.add(from.substring(startPos));
			startPos = from.indexOf(start,startPos+1);
		}
		
		String[] rtn = new String[returnList.size()];
		rtn = returnList.toArray(rtn);
		return rtn;
	}
	
}
