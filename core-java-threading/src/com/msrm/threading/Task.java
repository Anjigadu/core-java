package com.msrm.threading;

public class Task implements Runnable {

	@Override
	public void run() {
		System.out.println("Name: " + Thread.currentThread().getName());
	}

}
