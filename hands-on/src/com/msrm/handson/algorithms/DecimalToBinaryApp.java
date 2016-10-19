package com.msrm.handson.algorithms;

/**
 * Decimal to binary conversions, without using inbuilt methods
 * 
 * @author srirammuthaiah
 *
 */
public class DecimalToBinaryApp {

	public static void main(String[] args) {
		DecimalToBinaryApp app = new DecimalToBinaryApp();

		for (int decimal = 0; decimal < 17; decimal++) {
			System.out.println(app.decimalToBinarySolutionOne(decimal));
			System.out.println(app.decimalToBinarySolutionTwo(decimal));
			System.out.println(app.decimalToBinarySolutionThree(decimal));
		}
	}

	public String decimalToBinarySolutionThree(int decimal) {
		String binary = "";
		while (decimal > 0) {
			binary = (decimal & 1) + binary;
			decimal = decimal >>> 1;
		}
		return binary;
	}

	public String decimalToBinarySolutionTwo(int decimal) {
		String binary = "";
		while (decimal > 0) {
			binary = ((decimal % 2 == 0) ? 0 : 1) + binary;
			decimal = decimal / 2;
		}
		return binary;
	}

	public String decimalToBinarySolutionOne(int decimal) {
		String binary = "";
		while (decimal > 0) {
			if (decimal % 2 == 0)
				binary = 0 + binary;
			else
				binary = 1 + binary;
			decimal = decimal / 2;
		}
		return binary;
	}

}
