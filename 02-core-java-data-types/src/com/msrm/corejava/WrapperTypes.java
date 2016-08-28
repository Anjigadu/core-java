package com.msrm.corejava;

public class WrapperTypes {

	public static void main(String[] args) {
		Byte b = 23;
		Short s = 93;
		Character c = 'E';
		Integer i = 98_893;

		// l or L is used denote the value is Long type
		Long l = 23_943_223_894_843_433l;

		Float f = 23.547f;
		Double d = 8923.45746;

		Boolean bol = false;
		// string "true" denotes boolean TRUE other string denotes boolean FALSE
		Boolean bol2 = new Boolean("trues");

		System.out.println("Byte value is " + b);
		System.out.println("Short value is " + s);
		System.out.println("Character value is " + c);
		System.out.println("Integer value is " + i);

		System.out.println("Long value is " + l);

		System.out.println("Float value is " + f);
		System.out.println("Double value is " + d);

		System.out.println("Boolean value is " + bol);
		System.out.println("Boolean value is " + bol2);
	}

}
