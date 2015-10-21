package com.tyh.code;

public class Count_and_Say {

	public static void main(String[] args) {
		System.out.println(new Count_and_Say().countAndSay(5));
	}

    public String countAndSay(int n) {
        String ini = "1";
        int i = 1;
        while(i < n){
        	ini = readString(ini);
        	i++;
        }
        return ini;
    }
    
    public String readString(String s){
    	char[] chars = s.toCharArray();
    	char preChar = chars[0];
    	int count = 0;
    	StringBuilder sb = new StringBuilder();
    	for(char c : chars){
    		if(c == preChar){
    			count++;
    		}
    		else{
    			sb.append(count).append(preChar);
    			preChar = c;
    			count = 1;
    		}
    	}
    	sb.append(count).append(preChar);
    	return sb.toString();
    }
}
