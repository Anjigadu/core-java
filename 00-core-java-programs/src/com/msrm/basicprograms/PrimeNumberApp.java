package com.msrm.basicprograms;

public class PrimeNumberApp {

	public static void main(String[] args) {
		PrimeNumberApp app = new PrimeNumberApp();
		for (int number = 0; number < 100; number++) {
			if (app.isPrime(number)) {
				System.out.print(number + " ");
			}
		}
	}

	public boolean isPrime(int number) {

		if (number == 0 || number == 1)
			return false;

		if (number == 2)
			return true;

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
