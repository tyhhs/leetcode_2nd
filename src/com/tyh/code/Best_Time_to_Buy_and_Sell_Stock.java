package com.tyh.code;

public class Best_Time_to_Buy_and_Sell_Stock {

	public static void main(String[] args) {
		int[] prices = {1,2,3,4,5,1,8};
		System.out.println(new Best_Time_to_Buy_and_Sell_Stock().maxProfit(prices));
	}

    public int maxProfit(int[] prices) {
        int len = prices.length;
    	if(len == 0) return 0;
    	int min = prices[0];
    	int res = 0;
    	for(int i : prices){
    		if(i < min)
    			min = i;
    		else{
    			res = Math.max(res, i-min);
    		}
    	}
    	return res;
    }
}
