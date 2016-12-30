package com.msrm.corejava.generic._06exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Write a generic method to find the maximal element in the range [begin, end)
 * of a list.
 * 
 * @author srirammuthaiah
 *
 */
public class Question08 {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(3, 8, 1, 2, 9, 5, 7, 0, 4, 6);
		Integer max = max(ints, 3, 6);
		System.out.println("Maximal value is " + max);
	}

	public static <T extends Comparable<T>> T max(List<T> list, int start, int end) {
		Objects.requireNonNull(list);

		if (start > end)
			throw new RuntimeException("required start < end");

		int max = start;
		for (int i = start + 1; i <= end; i++) {
			if (!Objects.isNull(list.get(max)) && list.get(max).compareTo(list.get(i)) < 0) {
				max = i;
			}
		}
		return list.get(max);
	}

	public static <T extends Object & Comparable<? super T>> T maxFromOracleSite(List<? extends T> list, int begin, int end) {

		T maxElem = list.get(begin);

		for (++begin; begin < end; ++begin)
			if (maxElem.compareTo(list.get(begin)) < 0)
				maxElem = list.get(begin);
		return maxElem;
	}

}
