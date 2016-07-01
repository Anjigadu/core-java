package com.msrm.basicprograms;

import java.util.Arrays;

class SortingApp {

	public static void main(String[] args) {
		SortingApp app = new SortingApp();
		int[] numbers = { 3, 4, 2, 1, 8, 3, 4, 5, 9, 7, 6, 0, 2 };
		System.out.println(Arrays.toString(numbers));
		app.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}

	/*
	 * Bubble sort used for this sorting program, various sorting algorithms
	 * available such as Shell sort, Heap sort, Quick sort, Merge Sort, etc.
	 */
	public void sort(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					swap(numbers, i, j);
				}
			}
		}
	}

	private void swap(int[] nums, int x, int y) {
		int t = nums[x];
		nums[x] = nums[y];
		nums[y] = t;
	}

}
