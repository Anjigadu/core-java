package com.msrm.corejava.generic._02syntax;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RestrictionsOnGeneric {

	public static void main(String[] args) {
		Object[] strings = new String[4];
		strings[0] = "sriram";
		strings[1] = 100; // throw ArrayStoreException
	}

	// Cannot Instantiate Generic Types with Primitive Types
	@SuppressWarnings("unused")
	public void primitiveNotAllowed() {
		// List<int> list; // primitive not accepted
		// change to
		List<Integer> list;
	}

	// 2. Cannot Create Instances of Type Parameters
	public <T> void cantInstantiateGenericType(List<T> list, Class<T> type) {
		// T t = new T(); // throw error
		// list.add(t);

		// can be changed as

		T t = null;
		try {
			t = type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		list.add(t);

	}

	// 3. Cannot Declare Static Fields Whose Types are Type Parameters
	class Smartphone {
	}

	class Pager {
	}

	class TabletPC {
	}

	class MobileDevice<T> {
		// because, static is class level variable shared to all objects
		// private static T os;

		// due to different Types like Smartphone, Pager and TabletPC, static
		// field os will get confused and doesn't match for whose type it is
		// required
		MobileDevice<Smartphone> phone = new MobileDevice<>();
		MobileDevice<Pager> pager = new MobileDevice<>();
		MobileDevice<TabletPC> pc = new MobileDevice<>();
	}

	// 4. Cannot Use Casts or instanceof with Parameterized Types
	public <E> void notInstanceOf(List<E> list) {
		// if (list instanceof ArrayList<Integer>) {
		// }
		// // (or)
		// if (list instanceof ArrayList<E>) {
		// }
	}

	public <E> void okInstanceOf(List<?> list) {
		if (list instanceof ArrayList<?>) {
		}
	}

	// 5. Cannot Create Arrays of Parameterized Types
	public <T> void arrayTest(T t) {
		// T[] t = new T[4]; // throws error

		//@formatter:off
		Object[] strings = new String[4];
		strings[0] = "sriram";
		strings[1] = 100; // throw ArrayStoreException

//		Object[] stringLists = new List<String>[]; // compiler error, but
													// pretend it's allowed
//		stringLists[0] = new ArrayList<String>(); // OK
//		stringLists[1] = new ArrayList<Integer>(); // An ArrayStoreException
													// should be thrown,
													// but the runtime can't
													// detect it.
		//@formatter:on
	}

	// 6. Cannot Create, Catch, or Throw Objects of Parameterized Types
	// Extends Throwable indirectly
	class MathException<T> extends Exception {
		/* ... */ } // compile-time error

	// Extends Throwable directly
	class QueueFullException<T> extends Throwable { /* ... */
		// compile-time error
	}

	// A method cannot catch an instance of a type parameter:
	public static <T extends Exception, J> void execute(List<J> jobs) {
		    try {
		        for (J job : jobs)
		            // ...
		    } catch (T e) {   // compile-time error
		        // ...
		    }
		}

	// You can, however, use a type parameter in a throws clause:
	class Parser<T extends Exception> {
		public void parse(File file) throws T { // OK
			// ...
		}
	}

	// 7. Cannot Overload a Method Where the Formal Parameter Types of Each
	// Overload Erase to the Same Raw Type
	class Example {

		// Both Set<Integer> and Set<String> are same so, overloading is not
		// feasible
		public void print(Set<Integer> ints) {
		}

		public void print(Set<String> strings) {
		}
	}
}
