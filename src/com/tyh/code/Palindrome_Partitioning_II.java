package com.tyh.code;

public class Palindrome_Partitioning_II {

	public static void main(String[] args) {
		String s = "aabaaabc";
		System.out.println(new Palindrome_Partitioning_II().minCut(s));
	}

    public int minCut(String s) {
    	if(s.length()==0)return 0;
        int[]c=new int[s.length()+1];
        for(int i=0;i<s.length();i++)c[i]=Integer.MAX_VALUE;
        c[s.length()]=-1;
        for(int i=s.length()-1;i>=0;i--){
            for(int a=i,b=i;a>=0 && b<s.length() && s.charAt(a)==s.charAt(b);a--,b++) c[a]=Math.min(c[a],1+c[b+1]);
            for(int a=i,b=i+1;a>=0 && b<s.length() && s.charAt(a)==s.charAt(b);a--,b++) c[a]=Math.min(c[a],1+c[b+1]);
        }
        return c[0];
    }
}
