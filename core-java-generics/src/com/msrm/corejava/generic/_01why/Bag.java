package com.msrm.corejava.generic._01why;

public class Bag<T> {

	T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

}
