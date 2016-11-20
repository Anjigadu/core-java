package com.msrm.handson.java.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Faster file copy with mapped byte buffer
 * 
 * @author srirammuthaiah
 *
 */
public class ReadFileWithMappedByteBuffer {

	public static void main(String[] args) {
		String file = "app_20Nov2016_161043.log";
		ReadFileWithMappedByteBuffer app = new ReadFileWithMappedByteBuffer();
		app.readOut(file);
	}

	public void readOut(String file) {
		try (RandomAccessFile raFile = new RandomAccessFile(new File(file), "r");
				FileChannel fileChannel = raFile.getChannel();) {
			MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0,
					fileChannel.size());
			buffer.load();
			for (int i = 0; i < buffer.limit(); i++) {
				System.out.print((char) buffer.get());
			}
			buffer.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
