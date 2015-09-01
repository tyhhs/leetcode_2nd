package com.tyh.code;

public class Palindrome_Number {

	public static void main(String[] args) {
		int x = -1234321;
		System.out.println(new Palindrome_Number().isPalindrome(x));
	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		String number = Integer.toString(x);
		int length = number.length();
		for (int i = 0; i < length / 2; i++) {
			if (number.charAt(i) != number.charAt(length-1-i)) {
				return false;
			}
		}
		return true;
    }
}
