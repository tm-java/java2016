package java8.ch03.ex02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {
	public static void withLock(Lock myLock, Runnable runnable) {
		myLock.lock();
		try {
			runnable.run();
		} finally {
			myLock.unlock();
		}
	}

}
