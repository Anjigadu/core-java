public class FormatPI {

	public static void main(String []args) {
		System.out.format("%f = %1$+020.10f %n", Math.PI);
		double dd = 236839842432.235294358668802d;
		System.out.format("%+,30.15f %n", dd);
		System.out.println(dd);
	}

}
