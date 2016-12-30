package com.msrm.corejava.generic._05erasure;

class Node<T> {
	T t;

	public Node(T t) {
		this.t = t;
	}

	public void setData(T t) {
		System.out.println("Node.setData");
		this.t = t;
	}
}

public class MyNode extends Node<Integer> {

	public MyNode(Integer t) {
		super(t);
	}

	public void setData(Integer i) {
		System.out.println("MyNode.setData");
		super.setData(i);
	}

	public static void main(String[] args) {
		// Here is what happens as the code is executed:

		// - n.setData("Hello"); causes the method setData(Object) to be
		// executed on the object of class MyNode. (The MyNode class inherited
		// setData(Object) from Node.)

		// - In the body of setData(Object), the data field of the object
		// referenced by n is assigned to a String.

		// - The data field of that same object, referenced via mn, can be
		// accessed and is expected to be an integer (since mn is a MyNode which
		// is a Node<Integer>.
		
		// - Trying to assign a String to an Integer causes a ClassCastException
		// from a cast inserted at the assignment by a Java compiler.

		MyNode mn = new MyNode(5);
		Node n = mn;
		n.setData("sriram");
		
		Integer data = mn.t;
		System.out.println(n.t);
		System.out.println(mn.t);
	}

}
