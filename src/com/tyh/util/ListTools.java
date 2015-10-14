package com.tyh.util;

import java.util.List;

public class ListTools {
	public static void printListInList(List<List<Integer>> list){
		for(List<Integer> item : list){
			for(int i : item){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	public static void printStringList(List<String> list){
		for(String s : list){
			System.out.println(s);
		}
	}
}

