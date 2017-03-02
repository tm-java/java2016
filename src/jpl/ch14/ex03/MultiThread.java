package jpl.ch14.ex03;

public class MultiThread {

	public static void main(String[] args) {
		ShowNumber sn = new ShowNumber(0);
		Runnable service = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					sn.showAddedNumber(i);
				}
			}
		};

		new Thread(service).start();
		new Thread(service).start();
		new Thread(service).start();
	}

}
