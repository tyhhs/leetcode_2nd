package com.tyh.code;

import java.awt.image.RescaleOp;
import java.util.HashMap;
import java.util.Map;

import com.sun.crypto.provider.RSACipher;

public class Roman_to_Integer {

	public static void main(String[] args) {
		String s = "MMMCMXCIX";
		System.out.println(new Roman_to_Integer().romanToInt2(s));
	}
	public int romanToInt2(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('X', 10);
        map.put('C', 100);
        map.put('M', 1000);
        map.put('V', 5);
        map.put('L', 50);
        map.put('D', 500);
        int current;
        int previous = Integer.MIN_VALUE;
        int res = 0;
        for(int i = s.length()-1; i >= 0; i--){
        	current = map.get(s.charAt(i));
        	if(current < previous){
        		res -= current;
        	}
        	else {
				res += current;
			}
        	previous = current;
        }
        return res;
	}
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('X', 10);
        map.put('C', 100);
        map.put('M', 1000);
        map.put('V', 5);
        map.put('L', 50);
        map.put('D', 500);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if((c == 'I' || c == 'X' || c == 'C')&& i +1 < s.length()){
        		if(c == 'I'){
        			if(s.charAt(i+1) == 'V'){
        				res += 4;
            			i++;
        			}
        			else if (s.charAt(i+1) == 'X'){
        				res += 9;
        				i++;
        			}
        			else {
						res += 1;
					}
        		}
        		else if(c == 'X'){
        			if (s.charAt(i+1) == 'L') {
						res += 40;
						i++;
					}
        			else if (s.charAt(i+1) == 'C') {
						res += 90;
						i++;
					}
        			else {
						res += 10;
					}
        		}
        		else {
					if (s.charAt(i+1) == 'D') {
						res += 400;
						i ++;
					}
					else if (s.charAt(i+1) == 'M') {
						res += 900;
						i++;
					}
					else {
						res += 100;
					}
				}
        	}
        	else {
				res += map.get(c);
			}
		}
        return res;
    }
    
}
