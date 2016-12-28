package com.msrm.corejava.generic._04wildcard;

import java.util.Arrays;
import java.util.List;

/**
 * In some cases, the compiler infers the type of a wildcard. For example, a
 * list may be defined as List<?> but, when evaluating an expression, the
 * compiler infers a particular type from the code. This scenario is known as
 * <strong>wildcard capture</strong>.
 * 
 * @author srirammuthaiah
 *
 */
public class WildcardCapture {

	// scenario - 1 - starts here
	void foo(List<?> list) {
		// below line causes an error, to overcome it helper methods used
		// list.set(0, list.get(0));

		// helper method to define type and perform operation
		fooHelper(list);
	}

	private <T> void fooHelper(List<T> list) {
		list.set(0, list.get(0));
	}
	// scenario - 1 - ends here

	// scenario - 2 - starts here
	// swapping first elements of given two lists
	// This is can't be achieved by helper methods because there may be chance
	// that first list can have integers and second can have floats, whiling
	// exchanging, it would create an unwanted casting error and Generic will
	// fail in type checking so JDK will throw an error at the time of
	// compilation
	void swapFirst(List<?> list1, List<?> list2) {
		// Object object = list1.get(0);
		// list1.set(0, list2.get(0));
		// list2.set(0, object);
	}

	// though, below solution tried like helper, but both list should be in same
	// type in order to make this works
	<T> void swapFirstSol(List<T> list1, List<T> list2) {
		T t = list1.get(0);
		list1.set(0, list2.get(0));
		list2.set(0, t);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		WildcardCapture app = new WildcardCapture();
		List<Integer> ints1 = Arrays.asList(1, 3, 5, 9);
		List<Integer> ints2 = Arrays.asList(4, 2);
		List<Double> doubles = Arrays.asList(1.1, 3.3, 4.4);
		app.swapFirstSol(ints1, ints2);
		// below line will throw error
		// app.swapFirstSol(ints1, doubles);
	}

}
