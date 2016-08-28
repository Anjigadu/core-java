package com.msrm.corejava.threading;

public class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");
	}

	public static void main(String[] args) {
		MyThread t1 = new MyThread("mythread");
		t1.start();
	}
}
