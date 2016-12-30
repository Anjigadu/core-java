package com.msrm.corejava.generic._06exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Write a generic method to exchange the positions of two different elements in
 * an array.
 * 
 * @author srirammuthaiah
 *
 */
public class Question03 {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(3, 5, 1, 2, 4, 8, 11, 10);

		System.out.println(ints);
		exchange(ints, 0, 1);
		System.out.println(ints);
	}
	
	public static <T> void exchange(T[] t) {
		
	}
	
	public static <T> void exchange(List<T> list, int src, int dest) {
		Optional.ofNullable(list).ifPresent((e) -> {
			T t = e.get(src);
			e.set(src, e.get(dest));
			e.set(dest, t);
		});
	}

}
