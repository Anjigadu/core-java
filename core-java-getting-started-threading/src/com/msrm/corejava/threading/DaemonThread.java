package com.msrm.corejava.threading;

/**
 * Daemon thread will no longer available when its origin thread terminate
 * 
 * @author srirammuthaiah
 *
 */
public class DaemonThread {

	private static class MyDaemonThread extends Thread {
		public MyDaemonThread() {
			setDaemon(true);
		}

		public void run() {
			// Although, it is infinite loop, will get terminate once main
			// method terminates as because of MyDaemonThread is Daemon thread.
			while (true) {
				try {
					System.out.println("running MyDaemonThread");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyDaemonThread t = new MyDaemonThread();
		t.start();

		// keeping JVM delay to terminate
		Thread.sleep(1000);
	}

}
