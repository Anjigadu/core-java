import java.nio.file.*;
import java.io.*;
import java.nio.ByteBuffer;

public class ByteBufferUsage {
	public static void main(String []args) {
		String content = "Hi, I'm here, can you find me?";
		ByteBuffer buf = ByteBuffer.wrap(content.getBytes());
		System.out.println(buf.toString());

		// Read buffer via array
		System.out.println("Reading done by array()");
		for(byte b : buf.array()) {
			System.out.print((char)buf.get());
		}

		// flip resets the position=0, limit=current position and
		// marked flag discarded
		buf.flip();

		// Read char by char
		System.out.println("\nReading char by char");
		while(buf.hasRemaining()) {
			printInfo(buf);
		}

		buf.clear();

		System.out.println("\nBulk reading");
		int size = buf.capacity();
		byte [] buffer = new byte[size];
		buf.get(buffer);
		System.out.println(new String(buffer));
		System.out.println();
	}

	public static void printInfo(ByteBuffer buf) {
		System.out.format("position=%d, limit=%d, capacity=%d, data=%s%n", buf.position(), 
			buf.limit(), buf.capacity(), (char) buf.get());
	}
}
