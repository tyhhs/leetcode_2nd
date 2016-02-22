package com.tyh.code;

public class Reverse_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 43261596;
		Reverse_Bits reverse_bits = new Reverse_Bits();
		System.out.println(reverse_bits.bitRepresent(n));
		System.out.println(reverse_bits.reverseBits(n));
	}

	public int reverseBits(int n) {
        int res = 0;
        int index = 31;
        while(index >= 0){
            if((n & (1 << index)) != 0){
                res += (1 << (31 - index));
            }
            index--;
        }
        return res;
    }
	
	public String bitRepresent(int n){
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while(index < 32){
			if(((n >> index) & 1) == 1){
				sb.append('1');
			}
			else{
				sb.append('0');
			}
			index++;
		}
		sb.reverse();
		return sb.toString();
	}
}
