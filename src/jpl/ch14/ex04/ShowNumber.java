package jpl.ch14.ex04;

public class ShowNumber {
	private static Integer currentNumber = 0;

	public static synchronized void showAddedNumber(int num) {
		System.out.print(Thread.currentThread().getName() + " : ");
		System.out.print(currentNumber + " + " + num + " = ");
		currentNumber += num;
		System.out.println(currentNumber);
	}
}
