package jpl.ch14.ex04;

public class MultiThread {

	public static void main(String[] args) {
		ShowNumber sn = new ShowNumber();
		Runnable service = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					ShowNumber.showAddedNumber(i);
				}
			}
		};

		new Thread(service).start();
		new Thread(service).start();
		new Thread(service).start();
	}

}
