package com.msrm.handson.java.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Read a large file in chunks with fixed size buffer
 * 
 * @author srirammuthaiah
 *
 */
public class ReadFileWithFixedSizeBuffer {

	public static void main(String[] args) {
		String file = "app_20Nov2016_161043.log";
		ReadFileWithFixedSizeBuffer app = new ReadFileWithFixedSizeBuffer();
		app.readOut(file);
	}

	public void readOut(String file) {
		try (RandomAccessFile raFile = new RandomAccessFile(new File(file), "r");
				FileChannel fileChannel = raFile.getChannel()) {
			int capacity = 1024;
			ByteBuffer buffer = ByteBuffer.allocate(capacity);
			while (fileChannel.read(buffer) > 0) {
				buffer.flip();
				for (int i = 0; i < buffer.limit(); i++) {
					System.out.print((char) buffer.get());
				}
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
