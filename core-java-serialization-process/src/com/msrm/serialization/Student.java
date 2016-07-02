package com.msrm.serialization;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private int rollNumber;

	private String name;

	private float mathsMark;

	private float scienceMark;

	private transient float fee;

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMathsMark() {
		return mathsMark;
	}

	public void setMathsMark(float mathsMark) {
		this.mathsMark = mathsMark;
	}

	public float getScienceMark() {
		return scienceMark;
	}

	public void setScienceMark(float scienceMark) {
		this.scienceMark = scienceMark;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", mathsMark=" + mathsMark + ", scienceMark="
				+ scienceMark + ", fee=" + fee + "]";
	}

}
