package com.msrm.basicprograms;

public class Palindrome {

	public static void main(String[] args) {
		String str = "MADAM";
		Palindrome p = new Palindrome();
		if (p.isPalindrome(str)) {
			// if (p.palindrome(str.toCharArray(), 0, str.length() - 1)) {
			System.out.println(str + " is Palindrome");
		} else {
			System.out.println(str + " not is Palindrome");
		}
	}

	/**
	 * Recursive approach
	 * 
	 * @param ch
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean palindrome(char[] ch, int start, int end) {
		if (start < end) {
			if (ch[start] != ch[end]) {
				return false;
			}
		} else {
			return true;
		}
		return palindrome(ch, ++start, --end);
	}

	/**
	 * Iterative approach
	 * 
	 * @param str
	 * @return
	 */
	public boolean isPalindrome(String str) {
		if (str.length() % 2 != 1) {
			return false;
		}

		int lastIndex = str.length() - 1;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(0) != str.charAt(lastIndex))
				return false;
		}

		return true;
	}

}
