import java.nio.file.*;
import java.io.*;
import static java.nio.file.FileVisitResult.*;
import static java.nio.file.FileVisitOption.*;
import java.nio.file.attribute.*;
import java.util.EnumSet;

public class SymbolicFileVisitorSample {

	static class MyFileVisitor extends SimpleFileVisitor<Path> {
		public FileVisitResult visitFile(Path path, BasicFileAttributes attr) {
			System.out.printf("visitFile : %s%n", path);
			return CONTINUE;
		}

		public FileVisitResult visitFileFailed(Path path, IOException e) {
			System.out.printf("visitFileFailed: %s due to %s", path, e);
			return TERMINATE;
		}
	}

	public static void main(String []args) {
		try {
			MyFileVisitor visitor = new MyFileVisitor();
			int MAX_DEPTH_LEVEL = 3; // reads files in 3 depth of directory tree
			EnumSet<FileVisitOption> opts = EnumSet.of(FOLLOW_LINKS); // enables to read symbolic file/directory
			Files.walkFileTree(Paths.get("/tmp"), opts, MAX_DEPTH_LEVEL, visitor);	
		} catch (IOException e) {
			System.err.printf("IO Problem %s", e);
		}
	}


}
