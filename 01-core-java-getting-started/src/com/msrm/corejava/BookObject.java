package com.msrm.corejava;

/**
 * Accessing class member will be done by creating object for the class. with
 * the help of dot(.) operator and object can invoke the members
 * 
 * @author srirammuthaiah
 *
 */
public class BookObject {

	public static void main(String[] args) {

		BookClass java1 = new BookClass("Java Programming Volume - I", 2500.83f, "Sri M");
		System.out.println(java1);

		BookClass java2 = new BookClass("Java Programming Volume - II", 3423.34f, "Sri M");
		System.out.println(java2);

		java1.printInfo();
		java2.printInfo();
	}

}
