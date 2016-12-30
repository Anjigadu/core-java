package com.msrm.corejava.generic._06exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Write a generic method to count the number of elements in a collection that
 * have a specific property (for example, odd integers, prime numbers,
 * palindromes).
 * 
 * @author srirammuthaiah
 *
 */
public class Question01 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(4, 2, 1, 8, 9, 3, 6, 11, 7, 1, 3, 5);
		int evenNumbers = countIf(list, (e) -> e.intValue() % 2 == 0);
		System.out.println("Even numbers count is " + evenNumbers);
	}

	interface UnaryPredicate<P> {
		public boolean test(P p);
	}

	public static <T> int countIf(Collection<T> list, UnaryPredicate<T> predicate) {
		int count = 0;
		for (T t : list) {
			if (predicate.test(t))
				count++;
		}
		return count;
	}

}
