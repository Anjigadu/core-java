package com.msrm.exceptionhandling;

public class CleanUpApp {

	public static void main(String[] args) {
		CleanUpApp app = new CleanUpApp();
		int result = app.increment(3);
		System.out.println(result);
	}

	public int increment(int number) {
		try {
			// if the number is even, system should throw msg to the user
			if (number % 2 == 0) {
				throw new Exception("Please enter odd number");
			}
			return number++;
		} catch (Exception e) {
			System.out.println("Problem: " + e.getMessage());
			return 0;
		} finally {
			System.out.println("finally");
			return number;
		}
	}

	public void simpleFlow() {
		try {
			throw new Exception("Finally exception");
		} catch (Exception e) {
			System.out.println("I got it");
		} finally {
			System.out.println("Resources cleaned up");
		}
	}

}
