package com.msrm.collection;

public class Employee implements Comparable<Employee> {

	private int id;

	private String name;

	private String address;

	private int phoneNumber;

	private String mailId;

	public Employee(int id, String name, String address, int phoneNumber, String mailId) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.mailId = mailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + id;
		result = prime * result + ((mailId == null) ? 0 : mailId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + phoneNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Employee)) {
			return false;
		}

		Employee e = (Employee) obj;

		if (this.id != e.id)
			return false;
		if (!this.name.equals(e.name))
			return false;
		if (!this.address.equals(e.address))
			return false;
		if (this.phoneNumber != e.phoneNumber)
			return false;
		if (!this.mailId.equals(e.mailId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	// Natural comparision
	@Override
	public int compareTo(Employee o) {
		if (this.id > o.id)
			return 1;
		else if (this.id < o.id)
			return -1;
		return 0;
	}

}
