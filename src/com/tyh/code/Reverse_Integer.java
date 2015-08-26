package com.tyh.code;


public class Reverse_Integer {

	public static void main(String[] args) {
		int x = -2147483648;
		System.out.println(new Reverse_Integer().reverse(x));
	}
    public int reverse(int x) {
        if(x == 0){
        	return 0;
        }
        int flag = 1;
        long quotients = x;
        if(x < 0){
        	flag = -1;
        	quotients = -quotients;
        }       
        long res = 0;
        while(quotients != 0){
        	long remainder = quotients % 10;
        	quotients /= 10;
        	res = 10 * res + remainder;
        }
        if(flag == 1){
        	if(res > Integer.MAX_VALUE){
        		return 0;
        	}
        	return (int)res;
        }
        else{
        	res = -res;
        	if(res < Integer.MIN_VALUE){
        		return 0;
        	}
        	return (int)res;
        }
    }
}
