import java.nio.file.*;
import static java.nio.file.StandardCopyOption.*;
import java.io.*;

public class FileMove {
	
	public static void main(String []args) {
		try {
			String src = "/tmp/a.txt";
			String dest = "/tmp/mv.txt";
			Files.move(Paths.get(src), Paths.get(dest), ATOMIC_MOVE, REPLACE_EXISTING);
			System.out.println("Moved");
		} catch (IOException e) {
			System.err.format("Problem during moving : %s", e);
		}	
	}

}
