package com.msrm.exceptionhandling;

public class PropagationApp {

	public static void main(String[] args) {
		ComputeData cd = new ComputeData(5);

		int value = 0;
		try {
			value = cd.incrementByTwo();
		} catch (Exception e) {
			System.out.println("Could you please enter even number?");
		}

		System.out.println(value);

	}

}
