package com.msrm.corejava;

/**
 * Converting string data to primitive or wrapper type
 * 
 * @author srirammuthaiah
 *
 */
public class StringConversion {

	public static void main(String[] args) {
		StringConversion app = new StringConversion();
		app.stringToPrimitive();
		app.stringToWrapper();
		app.anyTypeToString();
	}

	@SuppressWarnings("unused")
	public void anyTypeToString() {
		int ints = 23423;
		float floats = 2343.2454f;
		String intStr = Integer.toString(ints);
		String intStr2 = ints + "";
		String floatStr = Float.toString(floats);
	}

	/**
	 * Converting string data to wrapper data type
	 */
	@SuppressWarnings("unused")
	public void stringToWrapper() {
		String number = "122";
		Byte byteObj = Byte.valueOf(number);
		Short shortObj = Short.valueOf(number);
		Integer intObj = Integer.valueOf(number);
		Long longObj = Long.valueOf(number);

		String chars = "F";
		Character charObj = Character.valueOf(chars.charAt(0));

		String decimal = "243.34";
		Float floatObj = Float.valueOf(decimal);
		Double doubleObj = Double.valueOf(decimal);
	}

	/**
	 * Converting string data to primitive data type
	 */
	@SuppressWarnings("unused")
	public void stringToPrimitive() {
		String number = "22";
		int intVal = Integer.parseInt(number);
		byte byteVal = Byte.parseByte(number);
		short shortVal = Short.parseShort(number);
		long longVal = Long.parseLong(number);

		String chars = "F";
		char charVal = chars.charAt(0);

		String decimal = "3443.43";
		double doubleVal = Double.parseDouble(decimal);
		float floatVal = Float.parseFloat(decimal);

		String bool = "true";
		boolean booleanVal = Boolean.parseBoolean(bool);
	}

}
