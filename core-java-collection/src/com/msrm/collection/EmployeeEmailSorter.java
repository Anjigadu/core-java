package com.msrm.collection;

import java.util.Comparator;

public class EmployeeEmailSorter implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getMailId().compareTo(o2.getMailId());
	}

}
