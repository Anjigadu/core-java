import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InvoiceWriter {

	static final String dataFile = "/tmp/invoicedata.dat";

	static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = {
   		"Java T-shirt",
    	"Java Mug",
    	"Duke Juggling Dolls",
    	"Java Pin",
    	"Java Key Chain"
	};

	public static void main(String []args) {
		try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
			for(int i = 0;i < prices.length;i++) {
				dos.writeInt(units[i]);
				dos.writeDouble(prices[i]);
				dos.writeUTF(descs[i]);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
