package com.msrm.handson.projecteuler;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.Find the sum of all the
 * multiples of 3 or 5 below 1000.
 * 
 * @author Sriram
 *
 */
public class SumOfSeriesApp {

	public static void main(String[] args) {
		SumOfSeriesApp app = new SumOfSeriesApp();
		int limit = 1000;
		int ans1 = app.solOne(limit);
		System.out.println(ans1);

		int ans2 = app.solTwo(limit);
		System.out.println(ans2);
	}

	/**
	 * Better solution which runs very minimally
	 * 
	 * @param limit
	 * @return
	 */
	public int solTwo(int limit) {
		int multipleA = 3;
		int multipleB = 5;
		int sum = 0;
		for (int i = 1; i < limit; i++) {
			if (i * multipleA < limit) {
				if (multipleA * i % multipleB == 0) { // do nothing
				} else {
					sum = sum + (i * multipleA);
				}
			} else {
				break;
			}
			if (i * multipleB < limit) {
				sum = sum + (i * multipleB);
			}
		}
		return sum;
	}

	/**
	 * Brute force method
	 * 
	 * @param limit
	 * @return
	 */
	public int solOne(int limit) {
		int sum = 0;
		for (int number = 1; number < limit; number++) {
			if (number % 3 == 0 || number % 5 == 0)
				sum += number;
		}
		return sum;
	}

}
