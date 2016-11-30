import java.nio.file.*;
import java.io.*;

public class ListRootDirs {
	public static void main(String []args) {
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		dirs.forEach(System.out::println);
	}
}
