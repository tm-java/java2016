package jpl.ch21.ex02;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class DataHandler {
	private WeakHashMap<File, byte[]> lastFileMap;

	byte[] readFile(File file) throws IOException {
		byte[] data;

		if (lastFileMap != null && lastFileMap.containsKey(file)) {
			data = lastFileMap.get(file);
			if (data != null) {
				return data;
			}
		}

		data = readBytesFromFile(file);
		lastFileMap = new WeakHashMap<File, byte[]>();
		lastFileMap.put(file, data);
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
