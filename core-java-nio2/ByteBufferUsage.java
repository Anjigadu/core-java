import java.nio.file.*;
import java.io.*;
import java.nio.ByteBuffer;

public class ByteBufferUsage {
	public static void main(String []args) {
		String text = "This is a line, which is 44 character length";
		int len = text.length();
		System.out.println(len);

		ByteBuffer b = ByteBuffer.allocate(100);
		log("After buffer allocating", b);
		
		// write data into buffer
		b = b.put(text.getBytes());

		// set position = 0, limit = bufCharSize 
		log("Before flipping", b);
		b.flip();
		log("After flipping", b);
		
		b.put("hello".getBytes());
		log("After writing `hello`", b);

		System.out.println(new String(b.array()));

		b.clear();
		log("After clearing", b);

		for(int i = 0;i < 10;i++) {
			// mark when 3rd index read
			if(i == 3) {
				b.mark();
				System.out.println("position marked");
			}
			System.out.println((char) b.get());
		}
		log("After read by get()", b);

		// set position back to mark
		b.reset();

		b.rewind();
		log("After rewinding", b);
		System.out.println(new String(b.array()));

		byte[] data = b.array();
		System.out.println(java.util.Arrays.toString(data));

	}

	public static void bufferRead() {
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

	public static void log(String msg, ByteBuffer buf) {
		System.out.format("%30s : %s.%n", msg, buf);
	}

	public static void printInfo(ByteBuffer buf) {
		System.out.format("position=%d, limit=%d, capacity=%d, data=%s%n", buf.position(), 
			buf.limit(), buf.capacity(), (char) buf.get());
	}
}
