package com.msrm.exceptionhandling;

public class ComputeData {

	private int number;

	public ComputeData(int number) {
		this.number = number;
	}

	public int incrementByTwo() throws Exception {
		if (this.number % 2 != 0) {
			throw new Exception();
		}
		return this.number + 2;
	}

}
