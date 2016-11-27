import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Locale;

public class ScanSummer {

	public static void main(String []args) {
		try (Scanner in = new Scanner(new FileReader("numbers.txt"));) {
			in.useLocale(Locale.US);
			double sum = 0;

			while(in.hasNext()) {
				if(in.hasNextDouble()) {
					sum += in.nextDouble();
				} else {
					in.next();
				}
			}

			System.out.println("Sum is " + sum);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
