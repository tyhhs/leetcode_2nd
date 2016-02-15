package com.tyh.code;

public class Excel_Sheet_Column_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int base = 1;
        for(int i = chars.length - 1; i >= 0; i--){
            res += (chars[i] - 'A' + 1) * base;
            base *= 26;
        }
        return res;
    }
}
