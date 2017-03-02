package jpl.ch16.ex12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class WeakPlayer implements Player {
	private final String book = "WeakPlayerBook.txt";
	private final Queue<Integer> strategy = new LinkedList<Integer>();

	public WeakPlayer() {
		InputStream in = WeakPlayer.class.getResourceAsStream(book);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			while ((line = br.readLine()) != null) {
				strategy.add(Integer.valueOf(line));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				in.close();
			} catch (IOException e) {
				// むし
			}
		}
	}

	/**
	 * Game.MIN_NUMBERから一つずつ加算して合っているか確認するだけ
	 */
	@Override
	public void play(Game game) {
		int num = nextNum();
		while (game.checkNumber(num) != Game.Result.HIT) {
			num = nextNum();
		}
	}

	/**
	 * 次のnumを決定する。 本来は、resultを受け取ってどうするか決めるが、WeakPlayerなので
	 * そのまま次の値をstrategyからとってくるだけ
	 * 
	 * @return
	 */
	private int nextNum() {
		return strategy.remove();
	}

	/**
	 * findResourceのオーバーライド
	 */
	public java.net.URL findResource(String name) {
		File f;
		try {
			f = fileFor(name);
			if (!f.exists()) {
				return null;
			}
			try {
				return f.toURL();
			} catch (java.net.MalformedURLException e) {
				return null; // 起きるはずがない
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	/**
	 * getResourcesのオーバーライド
	 * 
	 * 今回は、複数のリソースはないはずなので、findResourceを呼び出す
	 */
	public java.util.Enumeration<java.net.URL> findResources(String name) {
		return Collections.enumeration(Arrays.asList(findResource(name)));
	}

	private File fileFor(String bookName) throws FileNotFoundException {
		return new File("src/jpl/ch16/ex12/" + bookName);
	}

}
