import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URI;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class SamplePaths {
	public static void main(String []args) {
		// Creating path
		Path foo = Paths.get("/tmp/foo");
		System.out.println(foo);

		Path project1Path = Paths.get(URI.create("file:///tmp/foo/bar/project1"));
		printPathProperties(project1Path);

		Path relativePath = Paths.get("foo/bar");
		printPathProperties(relativePath);

		System.out.println("\nRemoving redundancies from Path");
		System.out.println("Path is " + Paths.get("/tmp/foo/bar/project1/../project2"));
		
		System.out.println("\nCoverting path");
		System.out.println("1. toUri : " + Paths.get("foo/bar/project1").toUri());
		System.out.println("2. toAbsolutePath : " + Paths.get("foo/bar/project1").toAbsolutePath());
		Path path = null;
		try {
			path = Paths.get("foo/bar/project1");
			System.out.println("3. toRealPath : " + path.toRealPath());
		} catch (NoSuchFileException x) {
    		System.err.format("%s: no such" + " file or directory%n", path);
    		// Logic for case when file doesn't exist.
		} catch (IOException x) {
    		System.err.format("%s%n", x);
    		// Logic for other sort of file error.
		}		

	}

		
	public static void printPathProperties(Path path) {
		System.out.println("Path : " + path);
		System.out.println("Filename " + path.getFileName());
		System.out.println("Parent : " + path.getParent());
		System.out.println("Subpath : " + path.subpath(0, 2));
		System.out.println("Count : " + path.getNameCount());
		System.out.println("Name : " + path.getName(0));
		System.out.println("Root : " + path.getRoot());
		System.out.println();
	}
}
