package java8.ch01.ex05;
/**
 * jpl14.3のコードを書き換え。
 * 減った行数は、二行。可読性は上がったと思う。
 * @author matsuitomomi
 *
 */
public class MultiThread {
	public static void main(String[] args) {
		ShowNumber sn = new ShowNumber(0);
		Runnable service = () -> {
			for (int i = 0; i < 10; i++) {
				sn.showAddedNumber(i);
			}
		};

		new Thread(service).start();
		new Thread(service).start();
		new Thread(service).start();
	}

}
