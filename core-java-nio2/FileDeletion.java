import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;
import java.nio.file.DirectoryNotEmptyException;
import java.io.IOException;

public class FileDeletion {

	public static void main(String []args) {
		Path filePath = Paths.get("del-io.txt");
		try {
			Files.delete(filePath);
			System.out.format("%s is deleted.%n", filePath);
		} catch(NoSuchFileException e) {
			System.err.format("%s is not there.%n", e.getFile());
		} catch(DirectoryNotEmptyException e) {
			System.err.format("%s is not empty.%n", filePath);
		} catch(IOException e) {
			// Might have file permission problem
			System.err.println(e);
		}
	}

}
