import java.nio.file.*;
import java.io.*;

public class DirsContent {
	public static void main(String []args) {
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get("/tmp"))) {
			ds.forEach(System.out::println);
		} catch (IOException | DirectoryIteratorException e) {
			System.err.format("Problem occurred due to %s", e);
		}
	}
}
