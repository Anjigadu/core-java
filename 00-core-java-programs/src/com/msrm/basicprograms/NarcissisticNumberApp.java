package com.msrm.basicprograms;

/**
 * In recreational number theory, a narcissistic number[1][2] (also known as a
 * perfect digital invariant (PPDI),[3] an Armstrong number[4] (after Michael F.
 * Armstrong)[5] or a plus perfect number)[6] is a number that is the sum of its
 * own digits each raised to the power of the number of digits
 * 
 * @author Sriram
 *
 */
public class NarcissisticNumberApp {

	public static void main(String[] args) {
		NarcissisticNumberApp app = new NarcissisticNumberApp();
		for (int number = 0; number < 10000; number++) {
			if (app.isPDI(number)) {
				System.out.print(number + " ");
			}
		}
	}

	/**
	 * isPDI - is the input number is Perfect Digital Invariant
	 * 
	 * @param number
	 * @return
	 */
	public boolean isPDI(int number) {

		if (number < 0) {
			throw new IllegalArgumentException("Input should be positive number. input is " + number);
		}

		int original = number;
		int digits = countDigits(number);
		int sum = 0;

		while (number > 0) {
			int remainder = number % 10;
			sum += Math.pow(remainder, digits);
			number = number / 10;
		}

		return original == sum;
	}

	private int countDigits(int number) {
		int count = 0;
		while (number > 0) {
			count++;
			number = number / 10;
		}
		return count;
	}

}
