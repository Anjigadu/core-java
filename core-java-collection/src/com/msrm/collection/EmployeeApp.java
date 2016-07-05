package com.msrm.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmployeeApp {

	public static void main(String[] args) {

		Employee e1 = new Employee(1, "abc", "Chennai", 12345, "abc@gmail.com");
		Employee e2 = new Employee(2, "xyz", "Chennai", 34434, "xyz@gmail.com");
		Employee e3 = new Employee(122, "raj", "Chennai", 452152, "raj@gmail.com");
		Employee e4 = new Employee(12, "kumar", "Salem", 344424, "kumar@gmail.com");
		Employee e5 = new Employee(100, "Aasha", "Madurai", 751545, "aasha@gmail.com");

		List<Employee> list = new ArrayList<>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);

		System.out.println(list);

		EmployeeEmailSorter mailSorter = new EmployeeEmailSorter();

		// Natural sorting
		// Collections.sort(list);

		// Property based sorting - here mailId is the property
//		Collections.sort(list, mailSorter);


		
		// Property based sorting  - here name is the property
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		
		System.out.println(list);		
		

		// System.out.println(e1.equals(e3));
		//
		// Set<Employee> set = new TreeSet<>();
		// set.add(e1);
		// set.add(e2);
		// set.add(e3);
		//
		// System.out.println(set);

	}

}
