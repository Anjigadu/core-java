package com.msrm.corejava.generics.why;

/**
 * Below class can store any type of objects
 * 
 * @author srirammuthaiah
 *
 */
public class Box {

	private Object obj;

	public Object get() {
		return this.obj;
	}

	public void set(Object obj) {
		this.obj = obj;
	}

}
