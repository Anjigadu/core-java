import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	
	public static void main(String[]args) {
		try(FileInputStream fin = new FileInputStream("input.txt");
			FileOutputStream fout = new FileOutputStream("/tmp/output.txt");) {
			int ch = fin.read();
			while(ch != -1) {
				fout.write(ch);
				ch = fin.read();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
