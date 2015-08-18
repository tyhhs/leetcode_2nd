package com.tyh.code;

public class Longest_Palindromic_Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aaccaa";
		System.out.println(new Longest_Palindromic_Substring().longestPalindrome(s));
	}
	public String longestPalindrome(String s) {
		String pre=prestr(s);
		int mx=0;//在i之前，延伸至最右端的位置
		int pi=1;//边界和中心
		int length=pre.length();
		//辅助数组p，记录以pre[i]为中心，向右延伸了p[i]个字符
		int[] p=new int[length];
		p[0]=0;
		for(int i=1;i<length;i++){
			if(mx>i){
				p[i]=mx-i>p[2*pi-i]?p[2*pi-i]:mx-i;//core
			}
			else{
				p[i]=1;
			}
			while(i-p[i]>0&&i+p[i]<length&&pre.charAt(i-p[i])==pre.charAt(i+p[i])){
				p[i]++;
			}
			if(i+p[i]>mx){
				mx=p[i]+i;
				pi=i;
			}
		}
		 //最大回文字符串长度
	    int maxlen = 0;
	    int index=0;
	    for(int i=0;i<length;i++)
	    {
	        if(p[i]>maxlen)
	        {
	            maxlen = p[i];
	            index=i;
	        }
	    }
	    int maxlength=maxlen-1;
	    if(maxlength%2==0){
	    	return s.substring((index-1)/2-1-maxlength/2+1, (index-1)/2+maxlength/2);
	    	
	    }
	    else{
	    	return s.substring((index-1)/2-1-(maxlength-1)/2, (index-1)/2+(maxlength-1)/2);	    	
	    }
	}
	public String prestr(String s){
		int length=s.length();
		char[] A=new char[2*length+4];
		A[1]='$';
		for(int i=0;i<length;i++){
			A[2*(i+1)]='#';
			A[2*(i+1)+1]=s.charAt(i);
			
		}
		A[2*length+2]='#';
		return String.valueOf(A);
	}
}
