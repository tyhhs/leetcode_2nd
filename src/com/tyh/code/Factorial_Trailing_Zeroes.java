package com.tyh.code;

public class Factorial_Trailing_Zeroes {

	public static void main(String[] args) {
		System.out.println(new Factorial_Trailing_Zeroes().trailingZeroes(2147483647));
	}

    public int trailingZeroes(int n) {
        long base = 5;
        int res = 0;
        while(n >= base){
            res += (n / base);
            base *= 5;
        }
        return res;
    }
}
