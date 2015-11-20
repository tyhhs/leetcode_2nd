package com.tyh.code;

public class Candy {

	public static void main(String[] args) {
		int[] ratings = {1,6,4,3,2,1,2};
		System.out.println(new Candy().candy(ratings));
	}

    public int candy(int[] ratings) {
    	int len = ratings.length;
    	if(len == 0) return 0;
    	int[] candies = new int[len];
    	candies[0] = 1;
    	//forward
    	for(int i = 1; i < len; i++){
    		if(ratings[i] > ratings[i-1]) 
    			candies[i] = candies[i-1] + 1;
    		else
    			candies[i] = 1;
    	}
    	//backward
    	for(int i = len-2; i >= 0; i--){
    		if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1])
    			candies[i] = candies[i+1] + 1;
    	}
    	
    	int sum = 0;
    	for(int i = 0; i < len; i++){
    		sum += candies[i];
    	}
    	return sum;
    }
}
