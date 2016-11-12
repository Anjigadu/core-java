package com.msrm.techgig.pgm.qa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Objective This challenge will help you in getting familiarity with arrays
 * which will be helpful when you will solve further problems on Techgig.
 * 
 * 
 * Task
 * 
 * For this challenge, you need to take integer as input on one line which will
 * tell number of array elements and array elements as an input on another line
 * and find the majority number and print that number to the stdout. If not
 * found return -1.
 * 
 * 
 * (Majority Element: A majority element in an array A[] of size n is an element
 * that appears more than n/2 times.)
 * 
 * 
 * Input Format
 * 
 * In this challenge, you will take number of elements as input on one line and
 * array elements which are space separated as input on another line.
 * 
 * 
 * Output Format
 * 
 * You will print the majority number to the stdout.
 * 
 * Sample Input 9 3 3 4 2 4 4 2 4 4
 * 
 * Sample Output
 * 
 * 4
 * 
 * @author srirammuthaiah
 *
 */
public class FindingMajorityNumber {

	public static void main(String[] args) {

		FindingMajorityNumber app = new FindingMajorityNumber();
		int[] numbers = app.parseInput();

		System.out.println(Arrays.toString(numbers));
		int result = app.findMajorityNumber(numbers);
		System.out.println(result);

	}

	public int findMajorityNumber(int[] numbers) {
		Map<Integer, Integer> counter = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];
			if (counter.containsKey(number))
				counter.put(number, counter.get(number) + 1);
			else
				counter.put(number, 1);

			if (counter.get(number) >= numbers.length / 2) {
				return number;
			}
		}

		return -1;
	}

	public int[] parseInput() {
		try (Scanner in = new Scanner(System.in)) {
			System.out.print("Enter limit: ");
			int limit = in.nextInt();
			System.out.println();
			int[] numbers = new int[limit];
			for (int i = 0; i < numbers.length; i++) {
				System.out.print("Enter number(" + (i + 1) + "): ");
				numbers[i] = in.nextInt();
			}
			return numbers;
		}
	}

}
