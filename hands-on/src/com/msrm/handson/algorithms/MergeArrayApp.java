package com.msrm.handson.algorithms;

import java.util.Arrays;

/**
 * Merge 2 sorted array, removing the duplicates.
 * 
 * @author srirammuthaiah
 *
 */
public class MergeArrayApp {

	public static void main(String[] args) {

		MergeArrayApp app = new MergeArrayApp();

		// Assumption: note that below 2 arrays should be sorted in nature
		int[] arrayOne = { 1, 2, 5, 9, 10, 14, 18, 49, 75 };
		int[] arrayTwo = { 2, 4, 6, 9, 14, 23, 49, 83, 98, 103, 493, 493 };
		int[] newArray = app.mergeSortedArray(arrayOne, arrayTwo);

		System.out.println("Array one: " + Arrays.toString(arrayOne));
		System.out.println("Array two: " + Arrays.toString(arrayTwo));
		System.out.println("New array: " + Arrays.toString(newArray));
	}

	public int[] mergeSortedArray(int[] arrayOne, int[] arrayTwo) {
		
		int[] tmpArray = new int[arrayOne.length + arrayTwo.length];

		int iterateTill = arrayOne.length > arrayTwo.length ? arrayOne.length : arrayTwo.length;
		int elementCount = 0;

		for (int i = 0; i < iterateTill; i++) {
			
		}

		int[] resultArray = null;
		return resultArray;
	}

}
