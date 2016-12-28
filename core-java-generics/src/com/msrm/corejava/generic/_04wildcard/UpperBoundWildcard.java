package com.msrm.corejava.generic._04wildcard;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundWildcard {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Number> numberList = new ArrayList<>();
		numberList.add(4);
		numberList.add(8f);
		numberList.add(23.3);
		numberList.add(0b111_111);
		System.out.println(numberList);

		// acceptable since input parameter is List<Number>
		System.out.println(sumOfListNoUpperBoundWildcard(numberList));
		System.out.println(sumOfListUpperBoundWildcard(numberList));

		List<Integer> integerList = new ArrayList<>();
		integerList.add(4);
		integerList.add(8);
		integerList.add(23);
		integerList.add(0b111_111);
		System.out.println(numberList);

		// below line not acceptable since input parameter is List<Number>
		// passed argument is List<Integer>
		// System.out.println(sumOfListNoUpperBoundWildcard(integerList));
		System.out.println(sumOfListUpperBoundWildcard(integerList));

		List<Double> doubleList = new ArrayList<>();
		doubleList.add(4.2);
		doubleList.add(98.23);

		List<? extends Number> mixNumbers = new ArrayList<>();
		mixNumbers.add(null);

		// correct syntax shown below. on the left hand side, means that class
		// type Number and its children are accepted, so Number -> Long, Number
		// -> Integer, Number -> Float, Number -> Integer ,etc works fine.
		// However, List of objects is not accepted due to Object -> Number
		// hierarchy
		List<? extends Number> nums1 = new ArrayList<Integer>();
		List<? extends Number> nums2 = new ArrayList<Double>();
		List<? extends Number> nums3 = new ArrayList<Long>();
		List<? extends Number> nums4 = new ArrayList<Number>();
		// List<? extends Number> nums5 = new ArrayList<Object>();
	}

	public static double sumOfListNoUpperBoundWildcard(List<Number> list) {
		double sum = 0.0;
		for (Number number : list) {
			sum += number.doubleValue();
		}
		return sum;
	}

	// Upper bounded wildcard
	public static double sumOfListUpperBoundWildcard(List<? extends Number> list) {
		double sum = 0.0;
		for (Number number : list) {
			sum += number.doubleValue();
		}
		return sum;
	}

}
