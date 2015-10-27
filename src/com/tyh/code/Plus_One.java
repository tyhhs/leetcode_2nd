package com.tyh.code;

public class Plus_One {

	public static void main(String[] args) {
		int digits[] = {1, 2, 3, 4, 5};
		int[] newDigits = new Plus_One().plusOne(digits);
		for(int i : newDigits){
			System.out.print(i);
		}
	}

    public int[] plusOne(int[] digits) {
    	for(int i = digits.length - 1; i >= 0; i--){
    		if(digits[i] < 9){
    			digits[i]++;
    			return digits;
    		}
    		digits[i] = 0;
    	}
    	int [] newDigits = new int[digits.length + 1];
    	newDigits[0] = 1;
    	return newDigits;
    }
}
