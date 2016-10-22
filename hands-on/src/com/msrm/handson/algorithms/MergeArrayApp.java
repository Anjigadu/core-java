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
		int[] arrayOne = { 1, 3, 5, 9, 10, 14, 18, 49, 75 };
		int[] arrayTwo = { 2, 4, 6, 8, 14, 23, 49, 83, 98 };
//		 int [] arrayTwo = { 2, 4, 6, 9, 14, 23, 49, 83, 98, 103, 493, 493 };
		int[] newArray = app.mergeSortedArraySolutionTwo(arrayOne, arrayTwo);

		System.out.println("Array one: " + Arrays.toString(arrayOne));
		System.out.println("Array two: " + Arrays.toString(arrayTwo));
		System.out.println("New array: " + Arrays.toString(newArray));
	}

	private class Result {
		int[] array;
		int index;
		int dups;

		public int[] getResult() {
			int[] result = new int[array.length - dups];
			System.arraycopy(array, 0, result, 0, array.length - dups);
			return result;
		}

	}

	public int[] mergeSortedArraySolutionTwo(int[] arrayOne, int[] arrayTwo) {
		int size = arrayOne.length + arrayTwo.length;
		Result result = new Result();
		result.array = new int[size];
		result.index = 0;
		int len = arrayOne.length > arrayTwo.length ? arrayOne.length : arrayTwo.length;

		for (int i = 0; i < len; i++) {
			if (i < arrayOne.length) {
				fillBuffer(result, arrayOne, i);
			}
			if (i < arrayTwo.length) {
				fillBuffer(result, arrayTwo, i);
			}
		}
		return result.getResult();
	}

	private void fillBuffer(Result result, int[] array, int arrayIndex) {
		if (result.index >= 1) {
			if (result.array[result.index - 1] > array[arrayIndex]) {
				result.array[result.index] = result.array[result.index - 1];
				result.array[result.index - 1] = array[arrayIndex];
				result.index++;
			} else if (result.array[result.index - 1] < array[arrayIndex]) {
				result.array[result.index++] = array[arrayIndex];
			} else {
				result.dups++;
			}
		} else {
			// buffer has no data, only one time this block executes
			result.array[result.index++] = array[arrayIndex];
		}
	}

	// This implementation would have redundant codes
	public int[] mergeSortedArraySolutionOne(int[] arrayOne, int[] arrayTwo) {

		int size = arrayOne.length + arrayTwo.length;
		int[] buffer = new int[size];
		int bufferIndex = 0;
		int dups = 0;
		int len = arrayOne.length > arrayTwo.length ? arrayOne.length : arrayTwo.length;

		for (int i = 0; i < len; i++) {

			if (i < arrayOne.length) {
				// buffer has already data in it
				if (bufferIndex >= 1) {
					if (buffer[bufferIndex - 1] > arrayOne[i]) {
						buffer[bufferIndex] = buffer[bufferIndex - 1];
						buffer[bufferIndex - 1] = arrayOne[i];
						bufferIndex++;
					} else if (buffer[bufferIndex - 1] < arrayOne[i]) {
						buffer[bufferIndex++] = arrayOne[i];
					} else {
						dups++;
					}
				} else {
					// buffer has no data, only one time this block executes
					buffer[bufferIndex++] = arrayOne[i];
				}
			}

			if (i < arrayTwo.length) {
				if (bufferIndex >= 1) {
					if (buffer[bufferIndex - 1] > arrayTwo[i]) {
						buffer[bufferIndex] = buffer[bufferIndex - 1];
						buffer[bufferIndex - 1] = arrayTwo[i];
						bufferIndex++;
					} else if (buffer[bufferIndex - 1] < arrayTwo[i]) {
						buffer[bufferIndex++] = arrayTwo[i];
					} else {
						dups++;
					}
				} else {
					buffer[bufferIndex++] = arrayTwo[i];
				}
			}
		}

		int[] result = new int[buffer.length - dups];
		System.arraycopy(buffer, 0, result, 0, buffer.length - dups);
		return result;
	}

}
