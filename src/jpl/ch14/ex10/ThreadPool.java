/*
 * Copyright (C) 2012, 2013, 2016 RICOH Co., Ltd. All rights reserved.
 */
package jpl.ch14.ex10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to be exectued by a
 * thread.
 *
 * [Instruction] Implement one constructor and three methods. Don't forget to
 * write a Test program to test this class. Pay attention to @throws tags in the
 * javadoc. If needed, you can put "synchronized" keyword to methods. All
 * classes for implementation must be private inside this class. Don't use
 * java.util.concurrent package.
 */
public class ThreadPool {
	private final Thread[] pool;
	private final Queue<Runnable> queue = new LinkedList<Runnable>();
	private final int queueSize;
	private Boolean stopped = false;

	/**
	 * Constructs ThreadPool.
	 *
	 * @param queueSize
	 *            the max size of queue
	 * @param numberOfThreads
	 *            the number of threads in this pool.
	 *
	 * @throws IllegalArgumentException
	 *             if either queueSize or numberOfThreads is less than 1
	 */
	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1 || numberOfThreads < 1) {
			throw new IllegalArgumentException();
		}
		this.queueSize = queueSize;
		Runnable execute = new Runnable() {
			public void run() {
				while (true) {
					Runnable removed = null;
					try {
						if ((removed = remove()) == null) {
							return;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					removed.run();
					
					
				}
			}
		};
		// numberOfThreads分スレッドを作成
		pool = new Thread[numberOfThreads];
		for (int i = 0; i < numberOfThreads; i++) {
			pool[i] = new Thread(execute);
		}
	}

	/**
	 * Starts threads.
	 *
	 * @throws IllegalStateException
	 *             if threads has been already started.
	 */
	public void start() {
		if (pool[0].isAlive()) {
			throw new IllegalStateException();
		}
		for (Thread th : pool) {
			th.start();
		}
	}

	/**
	 * Stop all threads and wait for their terminations.
	 *
	 * @throws IllegalStateException
	 *             if threads has not been started.
	 */
	public void stop() {
		if (!pool[0].isAlive()) {
			throw new IllegalStateException();
		}
		synchronized (queue) {
			for (int i = 0; i < pool.length; i++) {
				queue.add(null);		
			}
			
			queue.notifyAll();
		}
		
		for (int i=0;i<pool.length;i++) {
			try {
				pool[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Executes the specified(指定の) Runnable object, using a thread in the pool.
	 * run() method will be invoked in the thread. If the queue is full, then
	 * this method invocation(起動) will be blocked until the queue is not full.
	 * 
	 * @param runnable
	 *            Runnable object whose run() method will be invoked.
	 *
	 * @throws NullPointerException
	 *             if runnable is null.
	 * @throws IllegalStateException
	 *             if this pool has not been started yet.
	 */
	public synchronized void dispatch(Runnable runnable) {
		if (runnable == null) {
			throw new NullPointerException();
		}
		if (!pool[0].isAlive()) {		///一番目だけスレッドが終了する場合があるなら使用しない方がいいかも
			throw new IllegalStateException();
		}
		synchronized (queue) {
			if (queue.size() >= queueSize) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			queue.add(runnable);
			queue.notifyAll();
		}
	}

	// キューに何か入るまで待つ
	private Runnable remove() throws InterruptedException {
		synchronized (queue) {
			while (queue.size() == 0) {
				queue.wait();
			}
			Runnable rn = queue.remove();
			queue.notifyAll();
			return rn;
		}
	}

}
