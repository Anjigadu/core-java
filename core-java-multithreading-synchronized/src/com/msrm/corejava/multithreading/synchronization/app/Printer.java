package com.msrm.corejava.multithreading.synchronization.app;

public class Printer {

	public void print(String data) {
		System.out.print("{");
		System.out.print(data);

		// Assuming that print method take long time to print data, intendedly
		// making slow down this execution by putting delay on this method
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted: " + e.getMessage());
		}

		System.out.println("}");
	}

}
