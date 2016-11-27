import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileScanner {

	public static void main(String []args) {
		try(Scanner in = new Scanner(new FileInputStream("input.txt"));) {
			
			// By default, JavaWhiteSpace will be the delimiter for token
			// separation
			//in.useDelimiter(",");
			while(in.hasNext()) {
				System.out.println(in.next());
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
