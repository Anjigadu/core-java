import java.nio.file.*;
import java.io.*;

public class FilterDirsContent {

	public static void main(String []args) {
		Path dir = Paths.get("");
		System.out.println("Directory is " + dir);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.{java,class}")) {
			stream.forEach(System.out::println);	
		} catch (IOException | DirectoryIteratorException e) {
			System.err.format("Problem occrred due to %s", e);
		}	
	}

}
