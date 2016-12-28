package com.msrm.corejava.generics.why;

public class Bag<T> {

	T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

}
