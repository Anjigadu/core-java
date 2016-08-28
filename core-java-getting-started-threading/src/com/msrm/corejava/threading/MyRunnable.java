package com.msrm.corejava.threading;

public class MyRunnable implements Runnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable(), "myrunnable");
		t1.start();
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");
	}

}
