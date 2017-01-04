package jpl.ch09.ex01;

public class InfinityCalculation {

	public static void main(String[] args) {
		System.out.println("x\ty\t(x+y)\t\t(x-y)\t\t(x*y)\t\t(x/y)");
		System.out.println("----------------------------------------------------------------------");
		System.out.print("+∞\t+∞\t");
		System.out.print((Double.POSITIVE_INFINITY+Double.POSITIVE_INFINITY)+"\t");
		System.out.print((Double.POSITIVE_INFINITY-Double.POSITIVE_INFINITY)+"\t\t");
		System.out.print((Double.POSITIVE_INFINITY*Double.POSITIVE_INFINITY)+"\t");
		System.out.println((Double.POSITIVE_INFINITY/Double.POSITIVE_INFINITY));

		System.out.print("+∞\t-∞\t");
		System.out.print((Double.POSITIVE_INFINITY+Double.NEGATIVE_INFINITY)+"\t\t");
		System.out.print((Double.POSITIVE_INFINITY-Double.NEGATIVE_INFINITY)+"\t");
		System.out.print((Double.POSITIVE_INFINITY*Double.NEGATIVE_INFINITY)+"\t");
		System.out.println((Double.POSITIVE_INFINITY/Double.NEGATIVE_INFINITY));
		
		System.out.print("-∞\t-∞\t");
		System.out.print((Double.NEGATIVE_INFINITY+Double.NEGATIVE_INFINITY)+"\t");
		System.out.print((Double.NEGATIVE_INFINITY-Double.NEGATIVE_INFINITY)+"\t\t");
		System.out.print((Double.NEGATIVE_INFINITY*Double.NEGATIVE_INFINITY)+"\t");
		System.out.println((Double.NEGATIVE_INFINITY/Double.NEGATIVE_INFINITY));
	}

}
