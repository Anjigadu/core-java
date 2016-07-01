package com.msrm.basicprograms;

public class PrimeNumberApp {

	public static void main(String[] args) {
		PrimeNumberApp app = new PrimeNumberApp();
		for (int number = 0; number < 10_000; number++) {
			if (app.isPrime(number)) {
				System.out.print(number + " ");
			}
			// print a line every 100 number processed
			if (number % 100 == 0) {
				System.out.println();
			}
		}
	}

	public boolean isPrime(int number) {

		if (number <= 1)
			return false;

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
