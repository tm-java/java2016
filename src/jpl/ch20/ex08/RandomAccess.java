package jpl.ch20.ex08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.List;

public class RandomAccess {
	private final static String TABLE_FILE = "src/jpl/ch20/ex08/table.txt";
	private RandomAccessFile fas;
	private File file;

	public RandomAccess(File file) throws IOException {
		this.file = file;
		fas = new RandomAccessFile(file, "r");
		makeTableFile();
	}

	private void makeTableFile() throws IOException {
		String s = fas.readLine();
		List<Integer> list = new LinkedList<Integer>();

		while (s != null) {
			if (s.substring(0, 2).equals("%%")) {
				list.add((int) fas.getFilePointer());
			}
			s = fas.readLine();
		}
		fas.close();

		FileWriter tf = new FileWriter(TABLE_FILE);
		for (int l : list) {
			tf.write(l);
		}
		tf.close();
	}

	public static void main(String[] args) {
		File f = new File("src/jpl/ch20/ex08/song_data");
		List<Integer> list = new LinkedList<Integer>();

		try {
			RandomAccess ra = new RandomAccess(f);
			FileReader table = new FileReader(TABLE_FILE);
			LineNumberReader lnr = new LineNumberReader(table);
			int c;
			while ((c = lnr.read()) != -1) {
				list.add(c);
			}
			lnr.close();

			RandomAccessFile raf = new RandomAccessFile(f, "r");
			for (int i = 0; i < 5; i++) {
				int num = (int) (Math.random() * list.size());
				int count = (int) raf.length();
				if (num < (list.size() - 1)) {
					count = list.get(num + 1) - list.get(num) - 3;// %%改行分引く
				} else {
					count -= list.get(num);
				}
				System.out.println(num);
				raf.seek((long) list.get(num));
				int ch = 0;
				while (((ch = raf.read()) != -1) && (count > 0)) {
					System.out.print((char) ch);
					count--;
					//System.out.print(count);
				}
				System.out.println();
			}
			raf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
