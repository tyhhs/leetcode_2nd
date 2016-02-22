package com.tyh.code;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {

	public static void main(String[] args) {
		int n = 19;
		System.out.println(new Happy_Number().isHappy(n));
	}
	
	public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n != 1){
            n = getSquareSum(n);
            if(!set.contains(n)){
                set.add(n);
            }
            else{
                return false;
            }
        }
        return true;
    }
    
    private int getSquareSum(int n){
        String num = Integer.toString(n);
        int res = 0;
        char[] digits = num.toCharArray();
        for(char c : digits){
            res += Math.pow((c - '0'), 2);
        }
        return res;
    }
}
