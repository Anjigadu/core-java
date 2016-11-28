import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadDataByFiles {
	public static void main(String []args) {
		try (BufferedReader br = Files.newBufferedReader(Paths.get("/tmp/test-reader.txt"));) {
			String line = null;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch(IOException e) {
			System.err.format("Problem occurred while reading %s", e);
		}
	}
}
