import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;

public class InvoiceReader {

	public static void main(String []args) {
		String dataFile = "/tmp/invoicedata.dat";

		try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			System.out.println("Unit Price Description");
			while(true) {
				int unit = dis.readInt();
				double price = dis.readDouble();
				String description = dis.readUTF();
				System.out.format("%4d %5.2f %s %n", unit, price, description);
			}
		} catch(EOFException e) {
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
