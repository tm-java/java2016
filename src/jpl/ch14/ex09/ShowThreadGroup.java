package jpl.ch14.ex09;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ShowThreadGroup {
	/**
	 * 定期的にグループ内のスレッドとスレッドグループの階層を定期的に表示する
	 * @param g
	 */
	public static void show(ThreadGroup g) {
		Runnable service = new Runnable() {
			public void run() {
				while(true) {
					showThread(g);
					showThreadGroup(g);
					System.out.println();
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(service).start();
	}

	/**
	 * グループ内のスレッド表示
	 * @param g
	 */
	private static void showThread(ThreadGroup g) {
		Thread[] threadList = new Thread[20];
		int listSize = g.enumerate(threadList, false);
		System.out.println("active thread : ");
		for (int i = 0; i < listSize; i++) {
			System.out.println("\t" + threadList[i].getName());
		}
	}

	/**
	 * スレッドグループの階層表示
	 * @param g
	 */
	private static void showThreadGroup(ThreadGroup g) {
		ThreadGroup[] threadGroupList = new ThreadGroup[20];
		Stack<AbstractMap.SimpleEntry<ThreadGroup, Integer>> stack = new Stack<AbstractMap.SimpleEntry<ThreadGroup, Integer>>();
		
		System.out.println("ThreadGroup : ");
		
		//スタックに最初のグループを格納
		int deep = 0;//階層レベル
		int listSize = g.enumerate(threadGroupList, false);
		for (int i = 0; i < listSize; i++) {
			stack.add(new AbstractMap.SimpleEntry<ThreadGroup, Integer>(threadGroupList[i], deep));
		}

		//スタックの更新とスレッドグループの表示
		while (!stack.isEmpty()) {
			//pop
			AbstractMap.SimpleEntry<ThreadGroup, Integer> pop = stack.pop();
			//表示
			for (int i = 0; i < pop.getValue(); i++) {
				System.out.print("\t");
			}
			System.out.println(pop.getKey().getName());
			//スタックの更新
			threadGroupList = new ThreadGroup[20];
			listSize = pop.getKey().enumerate(threadGroupList, false);
			for (int i = 0; i < listSize; i++) {
				stack.add(new AbstractMap.SimpleEntry<ThreadGroup, Integer>(threadGroupList[i], pop.getValue()+1));
			}
		}

	}

}
