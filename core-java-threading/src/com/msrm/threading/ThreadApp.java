package com.msrm.threading;

public class ThreadApp {

	public static void main(String[] args) {
		System.out.println("Main method starts");
		Task task = new Task();
		Thread t1 = new Thread(task, "t1");
		Thread t2 = new Thread(task, "t2");
		Thread t3 = new Thread(task, "t3");

		t1.run();
		t2.run();
		t3.run();

		System.out.println("Main method ends");
	}

}
