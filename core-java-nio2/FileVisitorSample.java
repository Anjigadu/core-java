import java.nio.file.*;
import java.io.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;

public class FileVisitorSample {

	static class MyFileVisitor<Path> implements FileVisitor<Path> {

		public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attr) {
			System.out.println("preVisitDir : " + path);
			return CONTINUE;
		}

		public FileVisitResult visitFile(Path path, BasicFileAttributes attr) {
			System.out.println("visitFile : " + path);
			return CONTINUE;
		}

		public FileVisitResult visitFileFailed(Path path, IOException e) {
			System.out.println("visitFileFailed : " + path);
			return CONTINUE;
		}

		public FileVisitResult postVisitDirectory(Path path, IOException e) {
			System.out.println("postVisitDir : " + path);
			return CONTINUE;
		}
	}

	public static void main(String []args) {
		MyFileVisitor<Path> visitor = new MyFileVisitor<>();	
		try {
			Files.walkFileTree(Paths.get("/Users/srirammuthaiah/git/core-java/core-java-nio2"), visitor);
		} catch (IOException e) {
			System.err.format("Problem occurred %s", e);
		}
	}

}
