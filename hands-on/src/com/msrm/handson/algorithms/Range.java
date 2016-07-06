package com.msrm.handson.algorithms;

public class Range {

	public static void main(String[] args) {
		int items = 76;
		int count = 10;
		splitBy(count, items);
	}

	public static void splitBy(int count, int items) {

		count--;

		for (int start = 0, end = count; end < items; start = end + 1, end += count + 1) {

			System.out.println(start + " : " + end);

			if (end + count + 1 > items) {

				start = end + 1;

				System.out.println(start + " : " + (items - 1));
			}
		}

		System.out.println("Total items: " + items);

	}

}
