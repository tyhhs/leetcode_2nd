package com.tyh.code;

public class Divide_Two_Integers {

	public static void main(String[] args) {
		System.out.println(new Divide_Two_Integers().divide(-2147483648,1));

	}

    public int divide(int dividend, int divisor) {
    	long multiple = 0;
    	int flag = 1;
    	long absDividend = dividend;
    	if(absDividend < 0){
    		absDividend = Math.abs(absDividend);
    		flag = -flag;
    	}
    	long absDivisor = divisor;
    	if(absDivisor < 0){
    		absDivisor = Math.abs(absDivisor);
    		flag = -flag;
    	}

    	while(absDividend >= absDivisor){
    		long temp = absDivisor;
    		long tempMultiple = 1;
    		while(absDividend-temp >= temp){
    			temp = temp<<1;
    			tempMultiple = tempMultiple<<1;
    		}
    		multiple+=tempMultiple;
    		absDividend-=temp;
    	}
    	multiple *= flag;
    	if(multiple > Integer.MAX_VALUE || multiple < Integer.MIN_VALUE){
    		return Integer.MAX_VALUE;
    	}
    	return (int)multiple;
    }
}
