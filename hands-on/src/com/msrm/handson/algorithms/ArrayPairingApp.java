package com.msrm.handson.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 * 
 * @author srirammuthaiah
 *
 */
public class ArrayPairingApp {

	public static void main(String[] args) {
		int[] array = { 4, 3, 2, 0, 8, 9, 1, 5, 0 };
		int x = 5;
		ArrayPairingApp app = new ArrayPairingApp();
		List<String> pairs = app.pairs(array, x);
		System.out.println(pairs);
	}

	public List<String> pairs(int[] array, int x) {
		List<String> pairs = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == x) {
					pairs.add("(" + array[i] + "," + array[j] + ")");
				}
			}
		}
		return pairs;
	}

}
