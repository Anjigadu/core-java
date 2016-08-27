package com.msrm.basicprograms;

/**
 * Write a program that prints the numbers from 1 to 100. But for multiples of
 * three print "Fizz" instead of the number and for the multiples of five print
 * "Buzz". For numbers which are multiples of both three and five print
 * "FizzBuzz". Print a new line after each string or number.
 * 
 * @author Sriram
 *
 */
public class FizzBuzzApp {

	public static void main(String[] args) {
		FizzBuzzApp app = new FizzBuzzApp();
		int limit = 20;
		app.fizzBuzz(limit);
	}

	public void fizzBuzz(int limit) {
		for (int number = 0; number < limit; number++) {
			if (number % 3 == 0 && number % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (number % 3 == 0) {
				System.out.println("Fizz");
			} else if (number % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(number);
			}
		}
	}

}
