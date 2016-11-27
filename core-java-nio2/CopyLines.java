/**
* Character based stream to copy content of file
* line by line using Buffered manner
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CopyLines {
	
	public static void main(String []args) {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
			PrintWriter pw = new PrintWriter(new FileWriter("/tmp/output.txt"));) {
			String line = null;
			while(null != (line = br.readLine())) {
				pw.println(line);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
