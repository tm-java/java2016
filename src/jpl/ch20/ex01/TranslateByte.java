package jpl.ch20.ex01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {

	public static OutputStream translateByte(InputStream is, OutputStream os, byte from, byte to) throws IOException {
		int b;
		while ((b = is.read()) != -1) {
			os.write((byte) b == from ? to : b);
			// bの取りうる範囲は、0~255, fromの取りうる範囲は-128~127
			// （bはreadするから）
			// お互い取りうる範囲が違うから、比較対象としておかしい
			//対策は、int bの8ビットをbyteに変換する。byteとして読み込むと範囲が一致する
			// 教科書コード os.write(b == from ? to : b);
		}
		return os;
	}
}
