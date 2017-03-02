package jpl.ch14.ex05;

public class MultiThread {

	public static void main(String[] args) {
		ShowNumber sn = new ShowNumber(100);
		Runnable service = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					sn.showSubtractNumber(i);
				}
			}
		};

		new Thread(service).start();
		new Thread(service).start();
		new Thread(service).start();
	}

}
