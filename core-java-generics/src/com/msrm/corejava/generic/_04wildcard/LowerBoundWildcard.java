package com.msrm.corejava.generic._04wildcard;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundWildcard {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Number> numberList = new ArrayList<>();
		numberList.add(4);
		numberList.add(8f);
		numberList.add(23.3);
		numberList.add(0b111_111);
		System.out.println(numberList);

		addNumbers(numberList);
		System.out.println(numberList);
		// below line throws error as Double is not parent of Integer
		// addNumbers(doubleList);

		// below snippet shows DOs and DON'Ts. on left hand side, anything from
		// integer to its parent is accepted, Integer -> Number -> Object is
		// hierarchy
		List<? super Integer> ints1 = new ArrayList<Integer>();
		List<? super Integer> ints2 = new ArrayList<Number>();
		List<? super Integer> ints3 = new ArrayList<Object>();
		// List<? super Integer> ints4 = new ArrayList<Double>();

	}

	// Lower bounded wildcard
	// lists of Integer and the super types of Integer, such as Integer, Number,
	// and Object. you would specify List<? super Integer>
	public static void addNumbers(List<? super Integer> list) {
		for (int i = 0; i < 10; i++)
			list.add(i);
		// attempting to add double would cause an error due to list accepts
		// Integer or its super type. Double is not equal to Integer or its
		// parent hierarchy
		// list.add(23.3);
	}
}
