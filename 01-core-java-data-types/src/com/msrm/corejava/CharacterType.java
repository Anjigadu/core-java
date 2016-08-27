package com.msrm.corejava;

/**
 * Character data type will be useful for representing character data in Java
 * computer programming.
 * 
 * @author srirammuthaiah
 *
 */
public class CharacterType {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// unsigned 2 byte in size
		char firstChar = '\u0000';
		char lastChar = '\uffff';

		char aChar = 'a';
		char $Char = '$';
		char _Char = '_';

		System.out.println("Printing characters");
		System.out.println(firstChar);
		System.out.println(lastChar);
		System.out.println(aChar);
		System.out.println($Char);
		System.out.println(_Char);

		Character spaceCharObj = new Character(' ');
		System.out.println("*" + spaceCharObj + "*");

		// converting from char to Character
		char myChar = 'z';
		Character myCharacter = new Character(myChar); // no type casting
		// (or)
		Character myCharacter2 = myChar; // implicit type casting

		// converting from Character to char
		char chr = myCharacter.charValue();
		// (or)
		char chr2 = myCharacter;

	}

}
