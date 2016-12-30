package com.msrm.corejava.generic._06exercise;

/**
 * Given the following classes: Shape, Circle, Rectangle and Node
 * 
 * Will the following code compile? If not, why?
 * 
 * Node<Circle> nc = new Node<>();
 * 
 * Node<Shape> ns = nc;
 * 
 * @author srirammuthaiah
 *
 */

class Shape {
	/* ... */ }

class Circle extends Shape {
	/* ... */ }

class Rectangle extends Shape {
	/* ... */ }

class Node<T> {
	/* ... */ }

public class Question10 {

	public static void main(String[] args) {
		Node<Circle> nc = new Node<>();

		// below assignment will cause an error
		Node<Shape> ns = nc;
	}

}
