package com.msrm.handson.algorithms;

/**
 * Split the given number based on the count provided as input. For instance,
 * You have 76 items to be processed in a system, system can't take all items in
 * a sort. So need to be split item's and passed.
 * 
 * @author Sriram
 *
 */
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
