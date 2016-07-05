package com.msrm.basicprograms;

import java.util.Scanner;

/**
 * This programs gets the System.in that is input stream of an Operating System
 * and constructed Scanner object, through which we can give input to the
 * Operating System, unlike Console, it works on Eclipse like IDE as gets native
 * input stream from OS.
 * 
 * @author Sriram
 *
 */
public class ScannerInputApp {

	public static void main(String[] args) {
		ScannerInputApp app = new ScannerInputApp();
		String name = app.getInput("Please enter name");
		System.out.println("Hello, " + name);
	}

	public String getInput(String message) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(message + ": ");
		String input = scanner.nextLine();
		scanner.close();
		return input;
	}

}
