package com.msrm.corejava.generic._04wildcard;

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

		List<?> i = new ArrayList<>();
		// i.add(5); // will cause error
		Integer[] array = i.toArray(new Integer[0]);
		System.out.println(array);
		System.out.println(i.size());
	}

}
