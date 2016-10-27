package com.msrm.handson.algorithms;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * <pre>
 * You've given array of words, perform the following below
 * 1. find distinct words from array of words 
 * 2. remove special chars . , $ : ; -
 * 3. ignore the case sensitive
 * </pre>
 * 
 * @author srirammuthaiah
 *
 */
public class DupWordFinderApp {

	public static void main(String[] args) {
		String[] words = { "abc", "xyzs", "Abc", "ABC", "$df", "f**k", "f@cm", "xyzs", "sdk8" };

		Bag bag = new DupWordFinderApp().new Bag(words,
				new char[] { '$', '.', ',', '@', '*', ':', ';', '-', '_' });

		System.out.println("Words: " + bag);
	}

	private class Bag extends LinkedHashSet<String> {

		private static final long serialVersionUID = 1L;
		private char[] specialChars;

		public Bag(String[] words, char[] specialChars) {
			this.specialChars = specialChars;
			for (int i = 0; i < words.length; i++) {
				add(removeSpecialChars(words[i]));
			}
		}

		public String removeSpecialChars(String word) {
			char[] ch = word.toCharArray();
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < ch.length; i++) {
				if (!isSpecialChar(ch[i])) {
					buffer.append(ch[i]);
				}
			}
			return buffer.toString();
		}

		public boolean isSpecialChar(char ch) {
			for (int i = 0; i < specialChars.length; i++) {
				if (ch == specialChars[i])
					return true;
			}
			return false;
		}

		@Override
		public boolean add(String str) {

			if (isEmpty())
				return super.add(str);

			boolean found = false;
			Iterator<String> itr = iterator();
			while (itr.hasNext()) {
				if (str.equalsIgnoreCase(itr.next())) {
					found = true;
					break;
				}
			}
			if (!found)
				return super.add(str);
			else
				return false;
		}

	}

}
