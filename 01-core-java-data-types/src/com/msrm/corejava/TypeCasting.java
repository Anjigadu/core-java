package com.msrm.corejava;

/**
 * Type casting data types from primitive to Wrapper class types and vice versa
 * 
 * @author srirammuthaiah
 *
 */
public class TypeCasting {

	public static void main(String[] args) {
		TypeCasting app = new TypeCasting();
		app.primitiveToWrapper();
		app.wrapperToPrimitive();
	}

	@SuppressWarnings("unused")
	public void wrapperToPrimitive() {
		// wrapper to primitive type conversion
		Short shortObj = new Short((short) 343);
		short shortVal = shortObj.shortValue();
		// (or)
		short shortVal2 = shortObj;

		Byte byteObj = 22;
		byte byteVal = byteObj.byteValue();

		Integer intObj = 43553;
		int intVal = intObj.intValue();

		Character charObj = new Character('\u3fde');
		char charVal = charObj.charValue();

		Long longObj = 3_323_345L;
		long longVal = longObj.longValue();

		Float floatObj = 363.345f;
		float floatVal = floatObj.floatValue();

		Double doubleObj = 923_353_346_564_234_233.325;
		double doubleVal = doubleObj.doubleValue();
	}

	@SuppressWarnings("unused")
	public void primitiveToWrapper() {
		// primitive to Wrapper type conversion
		// short -> Short
		short shortNumber = 32;
		Short shortObject = shortNumber;

		// byte -> Byte
		byte byteVal = 123;
		Byte byteObject = byteVal;

		// int -> Integer
		int intNumber = 322983434;
		Integer intObject = intNumber;

		// char -> Character
		char charVal = 'k';
		Character charObject = charVal;

		// long -> Long
		long longVal = 32_354_434l;
		Long longObject = longVal;

		// float -> Float
		float floatVal = 23.35f;
		Float floatObject = floatVal;

		// double -> Double
		double doubleVal = 455_433_455.24;
		Double doubleObject = doubleVal;

	}

}
