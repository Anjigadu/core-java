package com.msrm.corejava.generic._06exercise;

import java.util.List;

public class Question07 {

	public static void print(List<? extends Number> list) {
		for (Number n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
