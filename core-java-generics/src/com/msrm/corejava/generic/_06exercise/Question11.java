package com.msrm.corejava.generic._06exercise;

/**
 * Consider this class:
 * 
 * <pre>
 * class Node<T> implements Comparable<T> {
 *    public int compareTo(T obj) { ... }
 *    // ...
 * }
 * </pre>
 * 
 * Will the following code compile? If not, why?
 * 
 * Node<String> node = new Node<>();
 * 
 * Comparable<String> comp = node;
 * 
 * Answer: This is will compile and work as expected
 * 
 * @author srirammuthaiah
 *
 */
public class Question11 {

	static class Node<T> implements Comparable<T> {
		public int compareTo(T obj) {
			return -1;
		}
	}

	public static void main(String[] args) {
		Node<String> node = new Node<>();
		Comparable<String> comp = node;
	}

}
