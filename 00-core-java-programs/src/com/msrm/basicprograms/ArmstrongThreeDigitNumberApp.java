package com.msrm.basicprograms;

/**
 * An Armstrong number of three digits is an integer such that the sum of the
 * cubes of its digits is equal to the number itself. For example, 371 is an
 * Armstrong number since 3**3 + 7**3 + 1**3 = 371.
 * 
 * Write a program to find all Armstrong number in the range of 0 and 999
 * 
 * @author Sriram
 *
 */
public class ArmstrongThreeDigitNumberApp {

	public static void main(String[] args) {
		ArmstrongThreeDigitNumberApp app = new ArmstrongThreeDigitNumberApp();
		for (int number = 0; number < 1000; number++) {
			if (app.isArmstrong(number)) {
				System.out.print(number + " ");
			}
		}
	}

	public boolean isArmstrong(int number) {

		if (number < 0) {
			throw new IllegalArgumentException("Input should be positive number. input is " + number);
		}

		// Taking backup of the input number
		int original = number;

		// Iteration result holder
		int sum = 0;

		while (number > 0) {
			int reminder = number % 10;
			sum += Math.pow(reminder, 3);
			number = number / 10;
		}

		return original == sum;
	}

}
