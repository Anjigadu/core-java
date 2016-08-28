package com.msrm.corejava.threading;

public class Tasker implements Runnable {

	private volatile boolean stop = false;

	public void stop() {
		stop = true;
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		while (!stop) {
			// doing the given task

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(name + " doing my task");
		}

		if (stop) {
			// do the resource releasing and clean up activities
			System.out.println(name + " done resource cleanup");
		}
	}

}
