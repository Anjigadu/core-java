package com.msrm.handson.java.nio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Read content from file traditional approach
 * 
 * @author srirammuthaiah
 *
 */
public class OldFileReaderApp {

	public static void main(String[] args) {
		String file = "app_20Nov2016_161043.log";
		OldFileReaderApp app = new OldFileReaderApp();
		app.readOut(file);
	}

	public void readOut(String file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String content = null;
			while ((content = br.readLine()) != null) {
				System.out.println(content);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
