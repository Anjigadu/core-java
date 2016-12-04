import java.nio.file.*;
import java.io.*;
import java.util.stream.*;

public class FileCharCount {
	
	private static int count;

	public static void main(String []args) throws IOException {
		char ch = 'e';
		Files.readAllLines(Paths.get("xanadu.txt"))
		     .stream()
			 .forEach(line -> {
			 	count += line.chars()
				             .filter(c -> c == ch)
					         .count();
			 });
		System.out.println(count);
	}

}
