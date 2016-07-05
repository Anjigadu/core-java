package com.msrm.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastSafeApp {

	public static void main(String[] args) {
		int[] ints = { 3, 2, 4, 1, 2, 8, 3, 0, 8 };

		FailFastSafeApp app = new FailFastSafeApp();

		List<Integer> numList = app.createList(ints);
		System.out.println(numList);

		app.removeOdd(numList);
		System.out.println(numList);
	}

	public void removeOdd(List<Integer> list) {

		// example code for Fail-safe operation
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			Integer number = itr.next();
			if (number % 2 != 0) {
				itr.remove();
			}
		}

		// example code for Fail-fast or ConcurrentModificationException
		// for (Integer number : list) {
		// if (number % 2 != 0) {
		// list.remove(number);
		// }
		// }

	}

	public List<Integer> createList(int[] ints) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < ints.length; i++) {
			list.add(ints[i]);
		}
		return list;
	}

}
