package com.msrm.corejava.generic._06exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * How do you invoke the following method to find the first integer in a list
 * that is relatively prime to a list of specified integers?
 * 
 * <pre>
 *		public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p)
 * </pre>
 * 
 * Note that two integers a and b are relatively prime if gcd(a, b) = 1, where
 * gcd is short for greatest common divisor.
 * 
 * @author srirammuthaiah
 *
 */
public class Question12 {

	interface UnaryPredicate<P> {
		boolean test(P p);
	}

	static class RelativelyPrimePredicate implements UnaryPredicate<Integer> {
		Collection<Integer> c;

		public RelativelyPrimePredicate(Collection<Integer> c) {
			this.c = c;
		}

		// Assume a > 0, b > 0
		public int gcd(int a, int b) {
			for (int r; (r = a % b) != 0; a = b, b = r) {
			}
			return b;
		}

		public boolean test(Integer x) {
			for (Integer i : c) {
				if (gcd(i, x) != 1)
					return false;
			}
			return c.size() > 0;
		}
	}

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);

		Collection<Integer> relativeNums = Arrays.asList(7, 18, 19, 25);
		RelativelyPrimePredicate p = new RelativelyPrimePredicate(relativeNums);

		int index = findFirst(nums, 0, 4, p);
		if (index != -1) {
			System.out.print(nums.get(index) + " is relatively prime to ");
			for (Integer k : relativeNums)
				System.out.print(k + " ");
			System.out.println();
		}
	}

	public static <T> int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) {
		for (; begin <= end; ++begin) {
			if (p.test(list.get(begin))) {
				return begin;
			}
		}
		return -1;
	}

}
