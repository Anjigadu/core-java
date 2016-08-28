package com.msrm.corejava.threading;

/**
 * Main method in Java program is a thread. This is program is getting the basic
 * information about running thread in JVM
 * 
 * @author srirammuthaiah
 *
 */
public class CurrentThreadInfo {

	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		System.out.println("Id: " + thread.getId());
		System.out.println("Name: " + thread.getName());
		System.out.println("Priority: " + thread.getPriority());
		System.out.println("State: " + thread.getState());
		System.out.println("ThreadGroup: " + thread.getThreadGroup());
	}

}
