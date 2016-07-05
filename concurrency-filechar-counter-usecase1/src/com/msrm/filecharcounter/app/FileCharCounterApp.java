package com.msrm.filecharcounter.app;

import java.io.File;
import java.util.List;

import com.msrm.filecharcounter.FileLoader;
import com.msrm.filecharcounter.Task;

public class FileCharCounterApp {

	public static void main(String[] args) {

		StopWatch.start();

		FileLoader fl = new FileLoader("/home/sriram/test");
		List<File> list = fl.list();

		int fileCount = 499;
		int i = 0;
		do {
			Thread t = new Thread(new Task(list, i, i + fileCount));
			// t.start();
			t.run();

			System.out.println(i + ": " + (i + fileCount) + ", Thread:" + t.getName());

			int next = i + 2 * fileCount;
			if ((next) >= list.size()) {

				Thread t1 = new Thread(new Task(list, i + 1 + fileCount, list.size() - 1));
				// t1.start();
				t1.run();

				System.out.println(i + 1 + fileCount + ": " + (list.size() - 1) + ", Thread:" + t1.getName());

				break;

			} else {
				i += fileCount + 1;
			}

		} while (true);

		System.out.println("No of files processed : " + list.size());

		StopWatch.stop();

	}

}
