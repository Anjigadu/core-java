import java.nio.file.*;
import java.io.*;

public class CustomFilterDirsContent {

	public static void main(String []args) {

		Path dir = Paths.get("/tmp");
		DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
			public boolean accept(Path file) {
				return Files.isDirectory(file);
			}
		};

		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir, filter)) {
			stream.forEach(System.out::println);
		} catch(IOException | DirectoryIteratorException e) {
			System.err.println("Problem occurred due to " + e);
		}
	}
}
