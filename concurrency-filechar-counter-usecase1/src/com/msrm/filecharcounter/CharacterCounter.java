package com.msrm.filecharcounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CharacterCounter {

	private File file;

	public CharacterCounter(File file) {
		this.file = file;
	}

	public void execute() {
		int count = 0;
		try (FileInputStream fis = new FileInputStream(file)) {
			while (fis.read() != -1)
				count++;
		} catch (IOException e) {
			System.out.println("FileNotFound: " + e.getMessage());
		}
		System.out.println(file + " : " + count);
	}

}
