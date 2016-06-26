package com.msrm.corejava.app;

import com.msrm.corejava.Child;
import com.msrm.corejava.Parent;

public class Application {

	public static void main(String[] args) {
		Parent p = new Parent();
		Number n = p.addTwo(2);
		System.out.println(n);

		Child c = new Child();
		Float f = c.addTwo(8);
		System.out.println(f);
	}

}
