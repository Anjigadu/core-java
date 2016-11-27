import java.io.BufferedInputStream;
import java.io.IOException;

public class CmdReader {
	public static void main(String []args) {
		
		try (BufferedInputStream bis = new BufferedInputStream(System.in)) {
			System.out.print("Enter age: ");
			int age = bis.read();

			System.out.println("Hello, you are " + age);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
