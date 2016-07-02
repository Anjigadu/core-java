package com.msrm.exceptionhandling;

public class SimpleExceptionApp {

	public static void main(String[] args) {
		int i = 1;
		try {
			if (i == 1) {
				throw new Exception("My exception");
			}
			System.out.println("Completed");
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}
		System.out.println("End");
	}

}
