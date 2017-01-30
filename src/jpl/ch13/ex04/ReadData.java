package jpl.ch13.ex04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ReadData {
	
	/**
	 * "type value"形式の行を持つ入力文字列を読み込んで、ArrayListに格納
	 * そのあと、全表示を行う
	 * */
	public static void readData(String path){
		
		List<Object> result = new ArrayList<Object>();
		String msg;		//データをまず文字列として読み込む用
		FileInputStream in = null;
		BufferedReader br = null;
		
		try{
			in = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(in);
			br = new BufferedReader(isr);
			while((msg = br.readLine()) != null){
				result.add(parseToWrapperObj(msg));
			}
			
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try{
				if(in != null) in.close();
				if(br != null) br.close();
			} catch (IOException e){
				;//無視
			}
		}
		
		
		for(Object obj : result){
			System.out.println(obj);
		}
	}
	
	/**
	 * 入力文字列を各ラッパークラスのオブジェクトに変換して返す
	 * */
	private static Object parseToWrapperObj(String input) {
		String[] data = input.split(" ");
		
		switch(data[0]){
		case "Byte":
			return new Byte(Byte.parseByte(data[1]));
		case "Short":
			return new Short(Short.parseShort(data[1]));
		case "Integer":
			return new Integer(Integer.parseInt(data[1]));
		case "Long":
			return new Long(Long.parseLong(data[1]));
		case "Float":
			return new Float(Float.parseFloat(data[1]));
		case "Double":
			return new Double(Double.parseDouble(data[1]));
		case "Character":
			return new Character(data[1].charAt(0));
		case "Boolean":
			return new Boolean(Boolean.parseBoolean(data[1]));
		default:
			return "Not Object";
		}
	}
	


}
