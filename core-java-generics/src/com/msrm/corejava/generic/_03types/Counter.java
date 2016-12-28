package com.msrm.corejava.generic._03types;

/**
 * Generic Methods and Bounded Type Parameters
 * 
 * @author srirammuthaiah
 *
 */
public class Counter {

	public static <T extends Comparable<T>> int countGreaterThan(T[] array, T element) {
		int count = 0;
		for (T t : array) {
			if (t.compareTo(element) > 0)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Integer[] array = { 3, 8, 2, 10, 7, 6, 1 };
		Integer element = 6;
		int count = Counter.<Integer>countGreaterThan(array, element);
		System.out.println("Count is " + count);
	}
}
