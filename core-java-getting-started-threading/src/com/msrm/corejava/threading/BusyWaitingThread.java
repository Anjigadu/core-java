package com.msrm.corejava.threading;

public class BusyWaitingThread {

	private static class BusyThread extends Thread {

		public void run() {
			int count = 0;
			long expireTime = System.currentTimeMillis() + 2000;
			while (true) {
				// exit condition to stop thread
				if (System.currentTimeMillis() > expireTime) {
					break;
				}
				
				count++;
			}
			System.out.println("Counted value is " + count);
		}

	}

	public static void main(String[] args) {
		BusyThread t = new BusyThread();
		t.start();
	}

}
