package com.msrm.basicprograms;

public class PowerOfTwoApp {

	public static void main(String[] args) {
		PowerOfTwoApp app = new PowerOfTwoApp();
		for (int number = 0; number < 20; number++) {
			if (app.isPowerOfTwo(number)) {
				System.out.println(number);
			}
		}
	}

	public boolean isPowerOfTwo(int number) {
		return (number & (number - 1)) == 0;
	}

}
