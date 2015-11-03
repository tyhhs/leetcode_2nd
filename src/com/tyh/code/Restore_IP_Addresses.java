package com.tyh.code;

import java.util.ArrayList;
import java.util.List;

public class Restore_IP_Addresses {

	public static void main(String[] args) {
		String s = "010010";
		List<String> list = new Restore_IP_Addresses().restoreIpAddresses(s);
		for(String string : list){
			System.out.println(string);
		}
	}
	
	public List<String> restoreIpAddresses(String s) {
		if(s == null || s.length() < 4){
			return new ArrayList<String>();
		}
		int length = s.length();
		List<String> list = new ArrayList<String>();
		for(int i = 1; i < 4 && i < length - 2; i++){
			for(int j = i+1; j < i + 4 && j < length - 1; j++){
				for(int k = j+1; k < j + 4 && k < length; k++){
					if(length - k > 3){
						continue;
					}
					else{
						String s1 = s.substring(0, i);
						String s2 = s.substring(i, j);
						String s3 = s.substring(j, k);
						String s4 = s.substring(k);
						if(isValidSection(s1) && isValidSection(s2) && isValidSection(s3) && isValidSection(s4)){
							list.add(s1+"."+s2+"."+s3+"."+s4);
						}
					}
				}
			}
		}
		return list;
	}
	
	public boolean isValidSection(String s){
		if(s.charAt(0) == '0' && s.length() > 1){
			return false;
		}
		int num = Integer.parseInt(s);
		if(num >= 0 && num <= 255){
			return true;
		}
		return false;
	}

}
