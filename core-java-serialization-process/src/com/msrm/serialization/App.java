package com.msrm.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

	public static void main(String[] args) {
//		Student s = new Student();
//		s.setRollNumber(100);
//		s.setName("Prakash");
//		s.setMathsMark(87.50f);
//		s.setScienceMark(35.25f);
//		s.setFee(10000.56f);
//		System.out.println(s);

		App app = new App();
//		app.serialize(s);

		 Student stu = app.deserialize();
		 System.out.println(stu);
	}

	public Student deserialize() {
		Student s = null;
		try (FileInputStream fis = new FileInputStream("/tmp/student.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			s = (Student) ois.readObject();

			System.out.println("Object de-serialized");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Problem occurred during de-serialization");
			e.printStackTrace();
		}
		return s;
	}

	public void serialize(Student stu) {
		try (FileOutputStream fos = new FileOutputStream("/tmp/student.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(stu);
			System.out.println("Object serialized");
		} catch (IOException e) {
			System.out.println("Problem occurred during serialization");
			e.printStackTrace();
		}
	}

	public void serialize0(Student stu) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("/tmp/student.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(stu);
			System.out.println("Object serialized");
		} catch (IOException e) {
			System.out.println("Problem occurred during serialization");
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
