package jpl.ch21.ex02;

/*
 * 元のデータホルダーは、byte[]を弱い参照にしているので、weakhashmapの使い方が違う。
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class DataHandler {
	private File lastFile;
	private Map<byte[], Object> lastData = new WeakHashMap<>();

	byte[] readFile(File file) throws IOException {
		byte[] data;

		if (file.equals(lastFile)) {
			for (byte[] b : lastData.keySet()) {
				return b;
			}
		}

		data = readBytesFromFile(file);
		lastData.clear();
		lastData.put(data, null);
		return data;
	}

	byte[] readBytesFromFile(File file) throws IOException {
		byte[] b = new byte[1];
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		while (fis.read(b) > 0) {
			bas.write(b);
		}
		bas.close();
		fis.close();
		b = bas.toByteArray();
		return b;
	}

}
