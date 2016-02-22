package com.tyh.code;

public class Number_of_1_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 11;
		System.out.println(new Number_of_1_Bits().hammingWeight(n));
	}
	public int hammingWeight(int n) {
		int count = 0;
		while(n != 0){
			count += (n & 1);
			n = n >>> 1;
		}
		return count;
	}
    public int hammingWeight1(int n) {
        //use a integer contains only a 1 bit to and the given integer, if the result is not 0, count + 1
        int count = 0;
        int index = 0;
        while(index < 32){
            if((n & (1 << index)) != 0){
                count++;
            }
            index++;
        }
        return count;
    }
}
