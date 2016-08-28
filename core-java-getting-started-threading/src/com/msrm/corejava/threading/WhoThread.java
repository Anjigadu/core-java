package com.msrm.corejava.threading;

/**
 * What will be the output of this program.
 * 
 * @author srirammuthaiah
 *
 */
public class WhoThread {

	private static class T extends Thread {
		public T(String name) {
			super(name);
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		T t = new T("t-thread");
		t.run();
	}

}
