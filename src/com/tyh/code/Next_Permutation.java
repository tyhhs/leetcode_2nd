package com.tyh.code;

import java.util.Arrays;

public class Next_Permutation {

	public static void main(String[] args) {
		int[] num = {1, 2, 5, 4, 3};
		new Next_Permutation().nextPermutation(num);
	}

	 public void nextPermutation(int[] num) {
		 int point = -1;
		 int length = num.length;
		 //find the first element which is not ascendant from the back
		 for(int i = length - 2; i >= 0; i--){
			 if (num[i] < num[i+1]) {
				point = i;
				break;
			}
		 }
		 if (point == -1) {
			Arrays.sort(num);
		 }
		 else{
			 int minIndex = point + 1;
			 for(int i = point +2; i < length; i++){
				 if (num[minIndex] > num[i] && num[i]>num[point]) {
					minIndex = i;
				}
			 }
			 num[point] ^= num[minIndex];
			 num[minIndex] ^= num[point];
			 num[point] ^= num[minIndex];
			 Arrays.sort(num, point + 1, length);
		 }
		 for(int i : num){
			 System.out.println(i);
		 }
	 }
	 
}
