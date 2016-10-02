package com.msrm.handson.algorithms;

import java.util.Arrays;

/**
 * <pre>
 * 
 * Input Format:
The first line of the input is an integer value N that corresponds to the number of days.
The next N integers represent the expenses made in the n days.
Output Format:
The output is an integer corresponding to the number of increasing trends.
Ex: input
6
19 
25
55
10
14
16
output : 2
input
7
100
90
80
70
60
50
40
output : 0
 * 
 * </pre>
 * 
 * @author srirammuthaiah
 *
 */
public class FindIncreaseTrendApp {

	public static void main(String[] args) {

		if (args.length < 2) {
			usage();
		}

		int n = Integer.parseInt(args[0]);
		int[] values = new int[n];

		for (int i = 1; i < n; i++) {
			try {
				values[i - 1] = Integer.parseInt(args[i]);
			} catch (Throwable e) {
				usage();
			}
		}

		System.out.println(Arrays.toString(args));
		System.out.println(Arrays.toString(values));

		FindIncreaseTrendApp app = new FindIncreaseTrendApp();
		int trend = app.solTwo(values);
		System.out.println("Trend is " + trend);

	}

	public int solTwo(int[] values) {
		int trend = 0;
		for (int i = 1; i < values.length; i++) {
			if (values[trend] < values[i]) {
				trend = i;
			}
		}
		return trend;
	}

	public int solOne(int[] values) {
		int value = Integer.MIN_VALUE;
		int trend = 0;

		for (int i = 0; i < values.length; i++) {
			if (values[i] > value) {
				value = values[i];
				trend = i;
			}
		}
		return trend;
	}

	private static void usage() {
		System.out.println("Oops, wrong execution! Please do as below");
		System.out.println("Usage: java FindIncreaseTrendApp 6 19 25 55 10 14 16");
	}

}
