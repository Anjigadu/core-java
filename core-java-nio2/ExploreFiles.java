import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.LinkOption;

public class ExploreFiles {
	public static void main(String []args) throws IOException {
		Path filePath = Paths.get("numbers.txt");
		System.out.println("Hidden : " + Files.isHidden(filePath));
		System.out.println("Full path : " + filePath.toAbsolutePath());
		System.out.println("Content-Type : " + Files.probeContentType(filePath));
		System.out.println("Size : " + Files.size(filePath));
		System.out.println("Directory? " + Files.isDirectory(filePath, LinkOption.NOFOLLOW_LINKS));

		System.out.println("\nFile attributes");
		System.out.println("Readable? : " + Files.isReadable(filePath));
		System.out.println("Writable? : " + Files.isWritable(filePath));
		System.out.println("Executable? : " + Files.isExecutable(filePath));

		Path otherPath = Paths.get("numbers.txt");
		System.out.println("Same file? : " + Files.isSameFile(filePath, otherPath));
	}
}
