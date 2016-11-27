import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyChars {

	public static void main(String[]args) {
		// try-with-resource handles closing of file resources
		try (FileReader r = new FileReader("input.txt");
			FileWriter w = new FileWriter("/tmp/output.txt");) {
			int ch;

			// `ch` variable holds last 16 bit of data, as Character stream
			// by default 16-bit Unicode supported
			while((ch = r.read()) != -1) {
				// it writes character data straight forward
				w.write(ch);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
