import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	
	public static void main(String[]args) {
		try(FileInputStream fin = new FileInputStream("input.txt");
			FileOutputStream fout = new FileOutputStream("/tmp/output.txt");) {
			int ch = fin.read();
			// `ch` int variable's last 8 bit holds information as stream is 
			// Byte Stream
			while(ch != -1) {
				fout.write(ch);
				ch = fin.read();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
