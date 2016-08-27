package com.msrm.basicprograms;

/**
 * Print "Hello" message without calling main methodS To run the below program
 * in command line $ java -Djava.system.class.loader=NoMain
 * 
 * @author srirammuthaiah
 *
 */
public class NoMain extends ClassLoader {

	public NoMain(ClassLoader cl) {
		super(cl);
		System.out.println("Hello");
		System.exit(0);
	}

}
