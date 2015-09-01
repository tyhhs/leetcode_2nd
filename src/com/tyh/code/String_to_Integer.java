package com.tyh.code;

public class String_to_Integer {

	public static void main(String[] args) {
		String str = "  -12345678909 ";
		System.out.println(new String_to_Integer().myAtoi(str));
	}

    public int myAtoi(String str) {
    	//invalid input
    	if(str == null || str.length() == 0){
    		return 0;
    	}
    	//eliminate whitespace 
    	str = str.trim();
    	//sign flag, 1 for +, -1 for -
    	int flag = 1;
    	//character pointer 
    	int i = 0; 
    	//record sign
    	if(str.charAt(i) == '+'){
    		i++;
    	}else if(str.charAt(i) == '-'){
    		flag = -1;
    		i++;
    	}
    	//get integer
    	long res = 0;
    	while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9' && i < 12){
    		res = 10 * res + (str.charAt(i) - '0');
    		i++;
    	}
    	//plus sign 
    	res *= flag;
    	//if or not in  range of representable values
    	res = res < Integer.MAX_VALUE ? res : Integer.MAX_VALUE;
    	res = res > Integer.MIN_VALUE ? res : Integer.MIN_VALUE;
    	return (int)res;
    }
}
