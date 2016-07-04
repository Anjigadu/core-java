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

		int fileCount = 500;

		int i = 0;
		do {
			Thread t = new Thread(new Task(list, i, i + fileCount - 1));
			// t.start();
			// t.run();

			// 0 - 2141
			// 0 - 499
			// 500 - 999
			// 1000 - 1499
			// 1500 - 1999
			// 2000 - 2141

			System.out.println(i + ": " + (i + fileCount - 1));
			
			i += fileCount + 1;

			

		} while (i < list.size());

		System.out.println("No of files processed : " + list.size());

		StopWatch.stop();

	}

}
