package jpl.ch10.ex01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//2017.3.3
// "\"" -> "\\\""?
public class EscapeSequence {
	
	public static String escapeSequence(String str){
		String rtn="";
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			
			if(c=='\n') rtn += '\n';
			else if(c=='\t') rtn += '\t';
			else if(c=='\b') rtn += '\b';
			else if(c=='\r') rtn += '\r';
			else if(c=='\f') rtn += '\f';
			else if(c=='\\') rtn += '\\';
			else if(c=='\'') rtn += '\'';
			else if(c=='\"') rtn += '\"';
			else rtn += c;
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
