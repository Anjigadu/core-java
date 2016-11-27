import java.io.Console;
import java.util.Arrays;

public class ConsoleReader {

	public static void main(String []args) {
		Console c = System.console();
		System.out.print("Enter name: " );
		String name = c.readLine();

		System.out.print("Enter password: ");
		char[] password = c.readPassword();

		System.out.print("Enter confirm password: ");
		char[] cpassword = c.readPassword();

		System.out.format("Hi, Mr.%s %n", name);
		if(Arrays.equals(password, cpassword)) {
			System.out.println("Your password matchs");
		} else {
			System.out.println("Password doesn't match");
		}
	}

}
