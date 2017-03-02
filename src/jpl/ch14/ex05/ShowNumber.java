package jpl.ch14.ex05;

public class ShowNumber {
	private static Integer currentNumber;

	public ShowNumber(int init) {
		currentNumber = init;
	}

	public void showSubtractNumber(int num) {
		synchronized (ShowNumber.class) {
			System.out.print(Thread.currentThread().getName() + " : ");
			System.out.print(currentNumber + " - " + num + " = ");
			currentNumber -= num;
			System.out.println(currentNumber);
		}
	}
}
