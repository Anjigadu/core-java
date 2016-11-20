package com.msrm.techgig.pgm.qa;

public class SquareRoot {

	public static void main(String[] args) {
		double result = sqrt(Double.parseDouble(args[0]));
		System.out.println("result : " + result);
	}

	public static double sqrt(double number) {
		double error = 1e-3;
		double s = number;
		while((s - number / s) > error) {
			s = (s + number / s) / 2;
		}
		return s;
	}

}
