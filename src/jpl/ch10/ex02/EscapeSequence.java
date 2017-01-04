package jpl.ch10.ex02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EscapeSequence {
	public static String escapeSequence(String str){
		String rtn="";
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			
			switch(c){
				case '\n': 
					rtn += '\n'; break;
				case '\t': 
					rtn += '\t'; break;
				case '\b': 
					rtn += '\b'; break;
				case '\r': 
					rtn += '\r'; break;
				case '\f': 
					rtn += '\f'; break;
				case '\\': 
					rtn += '\\'; break;
				case '\'': 
					rtn += '\''; break;
				case '\"': 
					rtn += '\"'; break;
				default:
					rtn += c; break;
			}
		}
		return rtn;
		
	}
	
	public static void main(String [] args){
		String file = "src/jpl/ch10/ex01/input";
		FileInputStream in = null;
		String tmp;
		String str = "";
		
		try{
			in = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			while((tmp = br.readLine()) != null){
				str += (tmp +"\n") ;
			}
			System.out.println(escapeSequence(str));
			
		} catch (IOException e){
			
		} finally{
			try{
				if(in != null) in.close();	
			} catch (IOException e){
				;//無視
			}
		}
	}

}
