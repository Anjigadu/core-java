package com.msrm.corejava.generics.usage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * - If you are writing a method that can be implemented using functionality
 * provided in the Object class.
 * 
 * - When the code is using methods in the generic class that don't depend on
 * the type parameter. For example, List.size or List.clear. In fact, Class<?>
 * is so often used because most of the methods in Class<T> do not depend on T.
 * 
 * @author srirammuthaiah
 *
 */
public class Wildcard {

	public static void printList(List<Object> list) {
		if (list == null)
			return;
		for (Object object : list) {
			System.out.println(object);
		}
	}

	// ------------------
	// Unbounded wildcard
	// this method accepts any type of generic
	// List<?> - means List of unknown types
	public static void printWildcardList(List<?> list) {
		if (list == null)
			return;
		for (Object object : list) {
			System.out.println(object);
		}
	}

	public static void main(String[] args) {
		List<Object> objList = Arrays.asList(new Object(), new Object());
		printList(objList);

		List<String> strList = Arrays.asList("a", "b", "c");
		// below statement won't run
		// printList(strList);

		// it accepts List<String> List<Object> etc.
		printWildcardList(strList);
		printWildcardList(objList);

		printList(null);
		printWildcardList(null);

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

		addNumbers(numberList);
		System.out.println(numberList);
		// below line throws error as Double is not parent of Integer
		// addNumbers(doubleList);

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

	// Lower bounded wildcard
	// lists of Integer and the supertypes of Integer, such as Integer, Number,
	// and Object. you would specify List<? super Integer>
	public static void addNumbers(List<? super Integer> list) {
		for (int i = 0; i < 10; i++)
			list.add(i);
	}

}
