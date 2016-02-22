package com.tyh.code;

public class Bitwise_AND_of_Numbers_Range {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 5;
		int n = 7;
		System.out.println(new Bitwise_AND_of_Numbers_Range().rangeBitwiseAnd(m, n));
	}

    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) return 0;
        int moveBits = 0;
        while(m != n){
            m = m >> 1;
            n = n >> 1;
            moveBits++;
        }
        m = m << moveBits;
        return m;
    }
}
