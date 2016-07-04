package com.msrm.filecharcounter.app;

public class StopWatch {

	private static long start;

	private StopWatch() {
	}

	public static void start() {
		start = System.nanoTime();
	}

	public static void stop() {
		long time = (System.nanoTime() - start);
		start = 0;
		float milliSecond = time / (1000f * 1000);
		float second = time / (1000f * 1000 * 60);
		float minute = time / (1000f * 1000 * 60 * 60);
		System.out.println(String.format("Time elapsed: %3.2fms | %3.2fs | %3.2fm", milliSecond, second, minute));
	}

}
