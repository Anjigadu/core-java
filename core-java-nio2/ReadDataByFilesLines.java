import java.nio.file.*;
import java.io.*;
import java.util.List;

public class ReadDataByFilesLines {

	public static void main(String []args) {
		try {
			List<String> lines = Files.readAllLines(FileSystems.getDefault().getPath("/tmp/test-reader.txt"));
			lines.forEach(System.out::println);
		} catch(IOException e) {
			System.err.format("Problem occurred while reading %s", e);
		}
	}

}
