package com.tyh.code;

public class Reverse_Words_in_a_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the sky is blue";
		System.out.println(new Reverse_Words_in_a_String().reverseWords(s));
	}

	public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        String res = words[words.length - 1];
        for(int i = words.length - 2; i >= 0; i--){
            res = res + " " + words[i];
        }
        return res;
    }
}
