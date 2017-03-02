package jpl.ch14.ex02;

public class PrintServer implements Runnable{
	private final String threadName = "PrintServerThread";
	private final PrintQueue requests = new PrintQueue();

	public PrintServer() {
		new Thread(this, threadName).start();
	}

	public void print(PrintJob job) {
		requests.add(job);
	}

	public void run() {
		if (!threadName.equals(Thread.currentThread().getName())) {
			return;
		}

		for (;;) {
			try {
				realPrint(requests.remove());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void realPrint(PrintJob job) {
		// 印刷の実際の処理を行う
		System.out.println("print : " + job.name());
	}

	public static void main(String[] args) {
		PrintServer ps = new PrintServer();
		for (int i = 0; i < 10; i++) {
			ps.print(new PrintJob("job" + i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
