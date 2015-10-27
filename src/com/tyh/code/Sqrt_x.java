package com.tyh.code;

public class Sqrt_x {

	public static void main(String[] args) {
		System.out.println(new Sqrt_x().mySqrt(2147395599));
		
	}
	//bit manipulation
    public int mySqrt(int x) {
    	if(x <= 0){
    		return 0;
    	}
    	int ans;
    	int bit = 1;
    	//find the most significant bit
    	while((long)(1<<bit) * (long)(1<<bit) <= x){
    		bit++;
    	}
    	bit--;//the most significant bit had found
    	ans = 1<<bit;
    	while(bit > 0){
    		bit--;
    		if((long)(ans + (1<<bit)) * (long)(ans + (1<<bit)) <= x){
    			ans += (1<<bit);
    		}
    	}
    	return ans;
    }
    
    //newton method
    public int mySqrt1(int x) {
    	if(x<=0){
    		return 0;
    	}
    	double ans=x;
    	while(Math.abs(Math.pow(ans, 2)-x)>0.000001){
    		ans=(ans+x/ans)/2;
    	}
    	return (int)ans;
    }
}
