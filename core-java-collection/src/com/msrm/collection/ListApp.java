package com.msrm.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ListApp {

	public static void main(String[] args) {
		int[] ints = { 3, 2, 4, 1, 2, 8, 3, 0, 8 };

		Set<Integer> mySet = new HashSet<>(java.util.Arrays.asList(3, 2, 4, 1, 2, 8, 3, 0, 8));

		ListApp app = new ListApp();
		List<Integer> numList = app.createList(ints);
		System.out.println(numList);

		Iterator<Integer> itr = numList.iterator();
		while (itr.hasNext()) {
			Integer num = itr.next();
			System.out.println(num);
		}

		System.out.println("\n Foreach loop");
		for (Integer integer : numList) {
			System.out.println(integer);
		}

	}

	public List<Integer> createList(int[] ints) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < ints.length; i++) {
			list.add(ints[i]);
		}
		return list;
	}

}
