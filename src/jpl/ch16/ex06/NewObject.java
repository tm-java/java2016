package jpl.ch16.ex06;

import java.lang.reflect.Constructor;

public class NewObject {
	/**
	 * 指定された名前のクラスのコンストラクタを返します
	 * 
	 * @param name クラスのバイナリー名
	 * @return クラスのコンストラクタ一覧
	 * @throws ClassNotFoundException 引数のクラスが存在しなかった場合
	 * @throws NullPointerException 引数がnullの時
	 */
	public static Constructor[] serchClass(String name) throws ClassNotFoundException{
		Class<?> classFor = Class.forName(name);
		return classFor.getConstructors();
	}
	
	
	public static void main(String[] args) {
		String name = "java.util.AbstractMap$SimpleEntry";
		try {
			Constructor[] con = NewObject.serchClass(name);
			for (Constructor c : con) {
				System.out.println(c.toString());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

}
