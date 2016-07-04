package com.msrm.filecharcounter;

import java.io.File;
import java.util.List;

public class Task implements Runnable {

	private List<File> files;

	private int start;

	private int end;

	public Task(List<File> files, int start, int end) {
		this.files = files;
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for (int i = start; i <= end; i++) {
			File file = files.get(i);
			CharacterCounter cc = new CharacterCounter(file);
			cc.execute();
		}
	}

}
