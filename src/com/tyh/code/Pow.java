package com.tyh.code;

public class Pow {

	public static void main(String[] args) {
		System.out.println(new Pow().myPow(8.88023, 3));
	}

    public double myPow(double x, int n) {
        if(n == 0){
        	return 1;
        }
        int flag = 1;
        long pow = n;
        if(n < 0){
        	pow = -pow;
        	flag = -1;
        }
        int positive = 1;
        if(x < 0 && (pow%2==1)){
        	x = -x;
        	positive = -1;
        }
    	double base = x;
    	double extra = 1;
        while(pow > 1){
        	if(pow % 2 == 1){
        		extra *= base;
        		pow--;
        	}
        	else{
        		base *=base;
        		pow = pow>>1;
        	}
        }
        base *= extra;
        if(flag == -1){
        	base = 1.0/base;
        }
        return positive * base;
    }
}
