package java8.ch01.ex05;

public class ShowNumber {
	private Integer currentNumber;
	
	public ShowNumber(int init) {
		currentNumber = init;
	}

	public synchronized void showAddedNumber(int num) {
		System.out.print(Thread.currentThread().getName() + " : ");
		System.out.print(currentNumber + " + " + num + " = ");
		currentNumber += num;
		System.out.println(currentNumber);
	}
}
