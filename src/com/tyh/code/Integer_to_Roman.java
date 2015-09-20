package com.tyh.code;

public class Integer_to_Roman {

	public static void main(String[] args) {
		int num = 3999;
		System.out.println(new Integer_to_Roman().intToRoman(num));
	}

    public String intToRoman(int num) {
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thoudsands ={"", "M", "MM", "MMM"};
        return thoudsands[num / 1000] + hundreds[(num % 1000)/100] + tens[(num % 100)/10] + ones[num%10];
    }
}
