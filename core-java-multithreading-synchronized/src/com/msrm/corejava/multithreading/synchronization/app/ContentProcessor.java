package com.msrm.corejava.multithreading.synchronization.app;

public class ContentProcessor extends Thread {

	private Printer printer;
	private String text;

	public ContentProcessor(Printer printer, String text) {
		this.printer = printer;
		this.text = text;
	}

	public void process() {
		// Invoking run() method of a thread
		start();
	}

	public void run() {
		// block level synchronization
		synchronized (printer) {
			printer.print(text);
		}
	}

}
