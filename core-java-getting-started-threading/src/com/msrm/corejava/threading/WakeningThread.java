package com.msrm.corejava.threading;

/**
 * How can a thread be woken up that has been put to sleep before using
 * Thread.sleep()?
 * 
 * @author srirammuthaiah
 *
 */
public class WakeningThread implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("doing...");
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " is interrupted and waken");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new WakeningThread(), "w-thread");
		t.start();

		System.out.println("Sleep " + Thread.currentThread().getName() + " for 3s");
		Thread.sleep(3000);

		System.out.println("Awenken " + t.getName());
		t.interrupt();
	}

}
