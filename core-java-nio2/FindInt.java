import java.nio.file.*;
import java.nio.channels.*;
import java.io.*;
import java.nio.*;

public class FindInt {
	public static void main(String []args) throws IOException {
		try (SeekableByteChannel channel = Files.newByteChannel(Paths.get("datafile"))) {
			ByteBuffer buf = ByteBuffer.allocate(8);
			channel.read(buf);
			long offset = buf.getLong(0);

			channel.position(offset);
			buf.rewind();

			channel.read(buf);
			int number = buf.getInt(0);
			System.out.println(number);
		}
	}
}
