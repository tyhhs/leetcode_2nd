package com.tyh.code;

public class Add_Binary {

	public static void main(String[] args) {
		String a = "1";
		String b = "11";
		System.out.println(new Add_Binary().addBinary2(a, b));
	}

    public String addBinary(String a, String b) {
    	StringBuilder sb = new StringBuilder();
        int carry = 0;
        if(a.length() != b.length()){
        	if(b.length() > a.length()){
        		String temp = b;
        		b = a;
        		a = temp;
        	}
        	int difference = a.length() - b.length();
        	for(int i = 0; i < difference; i++){
        		sb.append(0);
        	}
        	b = sb.toString() + b;
        	sb = new StringBuilder();
        }
        int i = a.length()-1;
        while(i >= 0){
        	char aDigit = a.charAt(i);
        	char bDigit = b.charAt(i);
        	if(aDigit == '0' && bDigit == '0'){
        		sb.insert(0, carry);
        		carry = 0;
        	}
        	else if(aDigit == '1' && bDigit == '1'){
        		sb.insert(0, carry);
        		carry = 1;
        	}
        	else{
        		sb.insert(0, carry == 1 ? 0 : 1);
        		//if carry is 1, it will still be 1
        	}
        	i--;
        }
        if(carry == 1){
        	sb.insert(0, 1);
        }
        return sb.toString();
    }
    
    public String addBinary2(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        StringBuilder stb = new StringBuilder();

        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int aByte;
        int bByte;
        int carry = 0;
        int result;

        while(i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;
            bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;
            result = aByte ^ bByte ^ carry;
            carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();
    }
}
