package com.msrm.corejava;

public class Child extends Parent {

	/**
	 * Since Java 5, it is possible to override a method by changing its return
	 * type. If subclass override any method by changing the return type of
	 * super class method, then the return type of overriden method must be
	 * subtype of return type declared in original method inside the super
	 * class.
	 * 
	 * Here, Parent.addTwo() returns Number and Child.addTwo() returns one of
	 * children type of Number class that is Float. This is covariant type
	 */
	public Float addTwo(Integer n) {
		return n + 2.0f;
	}

}
