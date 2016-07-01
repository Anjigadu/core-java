package com.msrm.basicprograms;

public class EvenOddNumberApp {

	public static void main(String[] args) {
		EvenOddNumberApp app = new EvenOddNumberApp();
		int number = 4;
		if (app.isEven(number)) {
			System.out.println(number + " is Even");
		} else {
			System.out.println(number + " is Odd");
		}
	}

	public boolean isEven(int number) {
		return number % 2 == 0;
	}

}
