package com.msrm.adv.java;

/**
 * How to return a class object in Java
 * @author srirammuthaiah
 *
 */
public class ReturnClass {

	public static void main(String[] args) {

		// Just for example, class A is created below, now I've object of A which is a
		A a = new A();
		
		// you can capture Class object of A
		Class<? extends A> clazz = a.getClass();
		System.out.println(clazz);
		
	}

	public Class<?> getClass(Object o) {
		return o.getClass();
	}
	
	private static class A {
	}

}
