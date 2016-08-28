package com.msrm.corejava.threading;

public class ThreadStopperApp implements Runnable {

	private volatile boolean stop = false;

	public static void main(String[] args) {
		ThreadStopperApp app = new ThreadStopperApp();
		Thread t = new Thread(app);
		t.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Stop thread!!!");
		app.stop();

		System.out.println("Thread stopped.");
	}

	public void stop() {
		this.stop = true;
	}

	@Override
	public void run() {
		while (!stop) {
			try {
				System.out.println("Running");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
