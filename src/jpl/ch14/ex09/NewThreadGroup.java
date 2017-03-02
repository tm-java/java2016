package jpl.ch14.ex09;

import java.util.Random;

public class NewThreadGroup {
	private void newThread(ThreadGroup parent) {
		Runnable service = new Runnable() {
			Random random = new Random();

			public void run() {
				try {
					Thread.sleep(100 * random.nextInt(10));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(parent, service).start();
	}

	/**
	 * @param parent
	 */
	public void newThreadGroups(ThreadGroup parent) {
		Random random = new Random();
		int size = (random.nextInt(9) + 1);
		ThreadGroup[] threadGroup = new ThreadGroup[size];
		for (int i = 0; i < size; i++) {
			threadGroup[i] = new ThreadGroup(parent, "ThreadGroup" + i);
			for (int j = 0; j < random.nextInt(3); j++) {
				newThread(threadGroup[i]);
			}
		}

		if (random.nextBoolean()) {
			newThreadGroups(threadGroup[random.nextInt(size)]);
		}
	}

	public static void main(String[] args) {
		NewThreadGroup ntg = new NewThreadGroup();
		ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
		ShowThreadGroup.show(mainThreadGroup);
		while(true) {
			ntg.newThreadGroups(mainThreadGroup);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
