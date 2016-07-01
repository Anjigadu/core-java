package com.msrm.basicprograms;

public class FactorialApp {

	public static void main(String[] args) {
		FactorialApp app = new FactorialApp();

		int number = 5;
		int result = app.computeFactorial(number);

		System.out.printf("Factorial of %d is %d%n", number, result);
		
		result = app.factorial(number);
		System.out.printf("Factorial of %d is %d%n", number, result);
	}

	/**
	 * Iterative approach
	 * 
	 * @param number
	 * @return
	 */
	public int computeFactorial(int number) {
		int result = 1;
		if (number < 0) {
			throw new IllegalArgumentException("Input should be non-negative integer");
		}
		for (int n = number; n > 0; n--) {
			result = result * n;
		}
		return result;
	}

	/**
	 * Recursive
	 * 
	 * @param number
	 * @return
	 */
	public int factorial(int number) {
		if (number < 0) {
			throw new IllegalArgumentException("Input should be non-negative integer");
		}
		if (number == 0) {
			return 1;
		}
		return number * factorial(number - 1);
	}

}
