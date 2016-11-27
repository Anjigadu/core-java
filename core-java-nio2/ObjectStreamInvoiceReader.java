import java.math.BigDecimal;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class ObjectStreamInvoiceReader {
	public static void main(String []args) {
		String dataFile = "/tmp/obj_invoicedata.dat";
		try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
			while(true) {
				int unit = ois.readInt();
				BigDecimal price = (BigDecimal) ois.readObject();
				String description = ois.readUTF();
				System.out.format("You ordered %d units of %s at %.2f%n", unit, description, price);
			}
		} catch (IOException | ClassNotFoundException e) {
		}
	}
}
