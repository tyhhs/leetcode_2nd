package com.tyh.code;

public class Valid_Palindrome {

	public static void main(String[] args) {
		String s = "aa";
		System.out.println(new Valid_Palindrome().isPalindrome2(s));
	}
    
	public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int head = 0;
        int tail = s.length()-1;
        while(head < tail){
        	//find next compare pairs
        	while(!isAlphanumeric(s.charAt(head)) && head < tail){
        		head++;
        	}
        	while(!isAlphanumeric(s.charAt(tail)) && head < tail){
        		tail--;
        	}
        	if(head <= tail){
        		char first = s.charAt(head);
        		char second = s.charAt(tail);
        		//transfer upper to lower
        		if(isUpper(s.charAt(head))){
        			first = (char)(first - 'A' + 'a');
        		}
        		if(isUpper(s.charAt(tail))){
        			second = (char)(second - 'A' + 'a');
        		}
        		if(first != second) return false;
        		head++;
        		tail--;
        	}
        	else return false;
        }
        return true;
    }
	//build a new string with all valid chars from the string s, then check if the new string is palindrome
	public boolean isPalindrome2(String s) {
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(char c : chars){
			if(isAlphanumeric(c)){
				if(isUpper(c))
					c = (char)(c - 'A' + 'a');
				sb.append(c);
			}
		}
		String check = sb.toString();
		int head = 0;
		int end = check.length()-1;
		while(head < end){
			if(check.charAt(head++) != check.charAt(end--))
				return false;
		}
		return true;
	}
	public boolean isAlphanumeric(char c){
		if((c >= 'a' && c <= 'z') ||
				(c >= 'A' && c <= 'Z')||
				(c >= '0' && c <= '9')){
			return true;
		}
		return false;
	}
	public boolean isUpper(char c){
		if(c >= 'A' && c <= 'Z'){
			return true;
		}
		return false;
	}
}
