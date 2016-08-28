package com.msrm.corejava.threading;

public class TaskManager {

	public static void main(String[] args) {
		TaskManager manager = new TaskManager();

		Tasker task1 = new Tasker();
		Tasker task2 = new Tasker();

		Thread t1 = new Thread(task1, "task1");
		Thread t2 = new Thread(task2, "task2");

		t1.start();
		t2.start();

		manager.makeDelay();

		task2.stop();

		manager.makeDelay();

		task1.stop();

	}

	public void makeDelay() {
		try {
			long timeout = (long) (Math.random() * 1000);
			System.out.println("will stop in " + timeout + "ms");
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
