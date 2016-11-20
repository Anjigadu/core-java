package com.msrm.handson.java.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * This is program is best for file in small size
 * 
 * @author srirammuthaiah
 *
 */
public class ReadFileWithFileSizeBuffer {

	public static void main(String[] args) {
		String file = "app_20Nov2016_161043.log";
		ReadFileWithFileSizeBuffer app = new ReadFileWithFileSizeBuffer();
		app.readOut(file);
	}

	public void readOut(String file) {

		try (RandomAccessFile raFile = new RandomAccessFile(new File(file), "r");
				FileChannel fileChannel = raFile.getChannel();) {
			long fileSize = fileChannel.size();
			ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
			fileChannel.read(buffer);
			buffer.flip();

			for (int i = 0; i < fileSize; i++) {
				System.out.print((char) buffer.get());
			}

			System.out.println("File size: " + fileSize);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
