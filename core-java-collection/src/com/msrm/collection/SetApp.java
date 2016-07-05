package com.msrm.collection;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class SetApp {

	public static void main(String[] args) {

		int[] ints = { 354, 214, 144, 11, 52, 458, 123, 450, 8958 };

		SetApp app = new SetApp();
		Set<Integer> numSet = app.createSet(ints);
		System.out.println(numSet);

		Iterator<Integer> itr = numSet.iterator();
		while (itr.hasNext()) {
			Integer num = itr.next();
			System.out.println(num);
		}

		System.out.println("\n Foreach loop");
		for (Integer i : numSet) {
			System.out.println(i);
		}
	}

	public Set<Integer> createSet(int[] ints) {
		// maintains insertion order
		// Set<Integer> set = new LinkedHashSet<>();

		// not maintaining insertion order
		// Set<Integer> set = new HashSet<>();

		// Ascending order
		Set<Integer> set = new TreeSet<>();

		for (int i = 0; i < ints.length; i++) {
			set.add(ints[i]);
		}

		return set;
	}

}
