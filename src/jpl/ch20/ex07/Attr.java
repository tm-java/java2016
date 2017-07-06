package jpl.ch20.ex07;

/*
 * valueがシリアライズできた時だけ、read/writeする。
 * できなかったらUnsupportedException投げてもいい
 * ByteArrayOutputStream作って、ObjectStreamからもらったものをシリアライズできるか確認する
 * ByteArrayでバイト配列に変換して、Dataストリームに投げる
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Attr {
	private final String name;
	private Object value = null;

	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public Attr(DataInputStream in) throws IOException {
		name = in.readUTF();
		in.close();
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}

	public String toString() {
		return name + " = '" + value + "'";
	}

	public void writeData(DataOutputStream out) throws IOException {
		out.writeUTF(name);
		//valueをアウトプットする方法がわかりませんでした。
		out.close();
	}

}
