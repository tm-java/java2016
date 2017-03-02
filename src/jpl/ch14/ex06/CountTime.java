package jpl.ch14.ex06;

public class CountTime {
	private long timer = 0;
	
	public void oneSecond() {
		try {
			while (true) {
				Thread.sleep(1000);//1s = 1000
				addTimer();
				System.out.println(timer);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void addTimer() {
		timer++;
		notifyAll();
	}

	public synchronized boolean countSeconds(int count) throws InterruptedException {
		wait();
		if ((timer % count) != 0) {
			return false;
		}
		return true;
	}
}
