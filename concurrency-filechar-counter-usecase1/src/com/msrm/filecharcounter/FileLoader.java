package com.msrm.filecharcounter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

	private List<File> files = new ArrayList<>();

	public FileLoader(String directory) {
		File dir = new File(directory);
		for (File file : dir.listFiles()) {
			files.add(file);
		}
	}
	
	public List<File> list() {
		return files;
	}

}
