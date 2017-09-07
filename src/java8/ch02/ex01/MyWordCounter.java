package java8.ch02.ex01;

import java.util.List;

public class MyWordCounter {
	private int count;
	
	public MyWordCounter() {
		count = 0;
	}
	
	private synchronized void countup() {
		count++;
	}
	
	public synchronized int count() {
		return count;
	}
	
	/**
	 * 並列処理で文字列のカウントをする
	 * @param words　文字列のリスト
	 * @param len　閾値
	 * @return 閾値以上の文字列長を持つものの個数
	 */
	//これだと、確認している最中にカウントアップをしている。
	//各スレッドの処理が終わった後に、合計するようにしなければならない。
	public void parallelWordCount(List<String> words, int len) {
		int from = 0;
		int to = words.size()/2;
		
		for (int i = 0; i < 2; i++) {
			List<String> seg = words.subList(from, to);
			from = to;
			to = words.size();
		
			new Thread( () -> {
				for (String w : seg) {
					if (w.length() > len) {
						countup();
					}
				}
			}).start();
		}
	}

}
