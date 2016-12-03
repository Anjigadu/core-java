import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;
import java.io.*;

public class FileCopy {

	public static void main(String []args) {
		String src = "a.txt";
		String dest = "/tmp/b.txt";

		try {
			Files.copy(Paths.get(src), Paths.get(dest), REPLACE_EXISTING, COPY_ATTRIBUTES);
			System.out.println("Copied");
		} catch (IOException e) {
			System.err.format("Problem while copying : %s", e);
		}
	}

}
