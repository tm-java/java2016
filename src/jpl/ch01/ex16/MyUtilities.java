package jpl.ch01.ex16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyUtilities {
	/**nameのファイルから、浮動小数点のデータの集まりを取得する*/
	public double[] getDataSet(String setName) throws BadDataSetException{
		String file = setName + ".dset";
		FileInputStream in = null;
		
		try{
			in = new FileInputStream(file);
			return readDataSet(in);
			
		} catch (IOException e){
			//ファイル名と、エラー内容を記憶してthrow
			throw new BadDataSetException(file,e);
		} finally{
			try{
				if(in != null) in.close();	
			} catch (IOException e){
				;//無視
			}
		}
	}
	
	/**FileInputStreamから、データを読み取ってdouble型配列に変換する*/
	public double[] readDataSet(FileInputStream in) throws IOException{
		String msg;		//データをまず文字列として読み込む用
		List lst = new ArrayList();
		
		try{
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			while((msg = br.readLine()) != null){
				lst.add(Double.parseDouble(msg));
			}
		} catch (IOException e){
			throw e;
		}
		double[] data = new double[lst.size()];
		
		for(int i=0;i<lst.size();i++){
			data[i] = (double) lst.get(i);
		}
		
		return data;
	}
	
	
	//nameのファイル内データをすべて表示する
	public void showDataSet(String name) throws BadDataSetException{
		try {
			double[] d = getDataSet(name);
			for(int i=0;i<d.length;i++){
				System.out.println(d[i]);
			}
		} catch (BadDataSetException e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyUtilities mu = new MyUtilities();
		String path = "src/jpl/ch01/ex16/";
		String s = "success";
		String f = "failure";
		
		try {
			//成功部分
			mu.showDataSet(path+s);
			//失敗部分
			mu.showDataSet(path+f);
			
		} catch (BadDataSetException e) {
			
			// BadDataSetExceptionに保持されている情報を元にエラー表示
			System.out.println("**********************************");
			e.printError();
			
			//printStackTraceで表示
			System.out.println("**********************************");
			e.printStackTrace();
		}
	}
	

}
