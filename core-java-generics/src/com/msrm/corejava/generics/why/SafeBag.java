package com.msrm.corejava.generics.why;

public class SafeBag {

	public static void main(String[] args) {
		// Below syntax tells that bag can hold
		// only Integer type of objects, which can
		// be validated at compile time so won't occur
		// any runtime exception
		Bag<Integer> bag = new Bag<Integer>();

		Integer number = 5;
		bag.set(number);

		// real pain eliminated, no casting required
		// type inferred by Generics
		Integer storedValue = bag.get();
		System.out.println(storedValue);

		// Below piece of code throws cast exception
		// String stringValue = bag.get();
	}

}
