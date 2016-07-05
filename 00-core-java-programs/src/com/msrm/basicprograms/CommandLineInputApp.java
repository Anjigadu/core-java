package com.msrm.basicprograms;

import java.io.Console;

/**
 * This program specifically gets input from command prompt in Windows or
 * Terminal in Linux operating system. When you try to execute in Eclipse like
 * IDE, end up with NullPointerException as there is no System Console prompt.
 * In Java, System.console() represents OS's command line utility where System
 * calls can be passed
 * 
 * @author Sriram
 *
 */
public class CommandLineInputApp {

	public static void main(String[] args) {
		CommandLineInputApp app = new CommandLineInputApp();
		String name = app.getInput("Please enter name");
		System.out.println("Hi, " + name);
	}

	public String getInput(String message) {
		Console console = System.console();
		System.out.print(message + ": ");
		return console.readLine();
	}

}
