package com.msrm.corejava.multithreading.synchronization.app;

public class Application {

	public static void main(String[] args) {
		Printer p = new Printer();

		// Same Printer object shared to all sort of ContentProcessor objects
		ContentProcessor cp1 = new ContentProcessor(p, "Welcome");
		ContentProcessor cp2 = new ContentProcessor(p, "To");
		ContentProcessor cp3 = new ContentProcessor(p, "Java");
		ContentProcessor cp4 = new ContentProcessor(p, "World");

		cp1.process();
		cp2.process();
		cp3.process();
		cp4.process();

	}

}
