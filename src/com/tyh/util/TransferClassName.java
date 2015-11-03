package com.tyh.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class TransferClassName {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		s = s.replace(' ', '_');
		s = s.replace('-', '_');
		new TransferClassName().placeTextOnclipboard(s);
		System.out.println(s+" has been placed on the clipboard");
	}

	public void placeTextOnclipboard(String s){
		//get the toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//get the clipboard
		Clipboard clipboard = toolkit.getSystemClipboard();
		//The setContents method of the Clipboard instance takes a Transferable
		//as first parameter. The StringSelection class implements the Transferable
		//interface.
		StringSelection stringSel = new StringSelection(s);
		//We specify null as the clipboard owner
		clipboard.setContents(stringSel, null);
	}
}
