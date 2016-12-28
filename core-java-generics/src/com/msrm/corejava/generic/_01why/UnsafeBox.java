package com.msrm.corejava.generic._01why;

public class UnsafeBox {

	public static void main(String[] args) {
		Integer number = 32;
		Box box = new Box();
		
		// Adding objects into bag is easy stuff
		// But the real problem comes only when 
		// accessing it from bag.
		System.out.println("Add element into Box");
		box.set(number);
		
		// Here, need to take care of the type of 
		// object. Otherwise, will throw error at
		// runtime. i.e. String storedValue = (String) box.get();
		Integer storedValue = (Integer) box.get();
		System.out.println(storedValue);
		
		String stringValue = (String) box.get();
		System.out.println(stringValue);
		
		
	}

}
