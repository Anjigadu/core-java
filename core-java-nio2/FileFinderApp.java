import java.io.*;
import java.nio.file.*;
import static java.nio.file.FileVisitResult.*;
import static java.nio.file.FileVisitOption.*;
import java.nio.file.attribute.*;
import java.util.*;

public class FileFinderApp {
	
	private Path fileToFind;
	private boolean found;

	public FileFinderApp(String file) {
		fileToFind = Paths.get(file);
	}

	private class FileProcessor extends SimpleFileVisitor<Path> {
		
		@Override
		public FileVisitResult visitFile(Path path, BasicFileAttributes attr) {
			//System.out.println("visitFile: " + path);
			if(fileToFind.equals(path)) {
				found = true;
				System.out.println("found: " + path);
			}
			return CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path path, IOException e) {
			if(e instanceof FileSystemLoopException) {
				System.err.format("Cycle deteced at %s%n", path);
			} else {
				System.err.format("Other problem %s at %s%n", e, path);
			}
			return CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path path, IOException e) {
			if(found) return TERMINATE;
			else return CONTINUE;
		}

	}

	public static void main(String []args) {
		String pathToSearch = "/tmp";
		String fileToSearch = "/tmp/a.txt";

		FileFinderApp app = new FileFinderApp(fileToSearch);
		FileProcessor fp = app.new FileProcessor();
		final int MAX_DEPTH = Integer.MAX_VALUE;
		EnumSet<FileVisitOption> opts = EnumSet.of(FOLLOW_LINKS);
		try {
			Files.walkFileTree(Paths.get(pathToSearch), opts, MAX_DEPTH, fp);
		} catch (IOException e) {
			System.err.printf("Problem in finding %s%n", e);
		}
	}

}
