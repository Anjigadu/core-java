import java.math.BigDecimal;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ObjectStreamInvoiceWriter {

	static final String dataFile = "/tmp/obj_invoicedata.dat";
 
    static final BigDecimal[] prices = { 
        new BigDecimal("19.99"), 
        new BigDecimal("9.99"),
        new BigDecimal("15.99"),
        new BigDecimal("3.99"),
        new BigDecimal("4.99") };
    static final int[] units = { 12, 8, 13, 29, 50 };
    static final String[] descs = { "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain" };

	public static void main(String []args) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			for(int i = 0;i < prices.length; i++) {
				oos.writeInt(units[i]);
				oos.writeObject(prices[i]);
				oos.writeUTF(descs[i]);
			}
			System.out.println("Invoice saved");
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}

}
