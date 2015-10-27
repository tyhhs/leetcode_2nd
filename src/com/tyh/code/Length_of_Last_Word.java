package com.tyh.code;

public class Length_of_Last_Word {

	public static void main(String[] args) {
		String s = "    fregrg  fgegrh     ";
		System.out.println(new Length_of_Last_Word().lengthOfLastWord(s));

	}

    public int lengthOfLastWord(String s) {
    	s = s.trim();
    	if(s.length() == 0){
    		return 0;
    	}
    	int count = 0;
    	int i = s.length() - 1;
    	while(i >= 0 && s.charAt(i) != ' '){
    		count++;
    		i--;
    	}
    	return count;
    }
}
