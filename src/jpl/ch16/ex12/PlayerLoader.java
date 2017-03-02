package jpl.ch16.ex12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class PlayerLoader extends ClassLoader {
	public Class<?> findClass(String name) throws ClassNotFoundException {
		try {
			byte[] buf = bytesForClass(name);
			return defineClass(null, buf, 0, buf.length);//name - > nullに変更
														//正しい第１引数は、パッケージも含めた名前。わからないのであればnull
		} catch (IOException e) {
			throw new ClassNotFoundException(e.toString());
		}
	}

	protected byte[] bytesForClass(String name) throws IOException, ClassNotFoundException {
		FileInputStream in = null;
		try {
			in = streamFor(name + ".class");
			int length = in.available();// バイト数を得る
			if (length == 0) {
				throw new ClassNotFoundException(name);
			}
			byte[] buf = new byte[length];
			in.read(buf);// バイト列を読み込む
			return buf;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

	/**
	 * 同パッケージ内にあるバイトコードのFileInputStreamを返す
	 * 
	 * @param className
	 *            クラスファイルの名前
	 * @return FileInputStream 指定されたクラスファイルの入力ストリーム
	 * @throws FileNotFoundException
	 *             指定のクラスファイルが見つからない時
	 */
	private FileInputStream streamFor(String className) throws FileNotFoundException {
		return new FileInputStream("src/jpl/ch16/ex12/" + className);
	}
}
