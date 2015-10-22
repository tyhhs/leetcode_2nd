package com.tyh.code;

public class Multiply_Strings {

	public static void main(String[] args) {
		String num1 = "0";
		String num2 = "0";
		System.out.println(new Multiply_Strings().multiply(num1, num2));
	}

    public String multiply(String num1, String num2) {
    	if(num1.equals("0") || num2.equals("0")){
    		return "0";
    	}
    	int length1 = num1.length();
    	int length2 = num2.length();
    	int[] res = new int[length1 + length2];
    	for(int i = length1 - 1; i >= 0; i--){
    		for(int j = length2 - 1; j >= 0; j--){
    			int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
    			res[i+j+1] += temp;
    			res[i+j] += res[i+j+1]/10;
    			res[i+j+1] %= 10;
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	int i = 0;
    	while(res[i] == 0){
    		i++;
    	}
    	for(int j = i; j < res.length; j++){
    		sb.append(res[j]);
    	}
    	return sb.toString();
    }
}
