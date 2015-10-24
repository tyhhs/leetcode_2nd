package com.tyh.util;

import java.util.Scanner;

public class TransferClassName {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		s = s.replace(' ', '_');
		s = s.replace('-', '_');
		System.out.println(s);
	}

}
