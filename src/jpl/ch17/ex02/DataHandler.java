package jpl.ch17.ex02;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class DataHandler {
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	byte[] readFile(File file) throws IOException {
		byte[] data;

		if (lastFile != null && file.equals(lastFile.get())) {
			data = lastData.get();
			if (data != null) {
				return data;
			}
		}

		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
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
		//return Files.readAllBytes(file.toPath);

	}

}
