package com.tyh.code;

public class Best_Time_to_Buy_and_Sell_Stock_II {

	public static void main(String[] args) {
		int prices[] = {1,2,3,4,1,3,2,8};
		System.out.println(new Best_Time_to_Buy_and_Sell_Stock_II().maxProfit(prices));
	}

    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int res = 0;
    	for(int i = 1; i < prices.length; i++){
    		if(prices[i] > prices[i-1]) 
    			res += prices[i] - prices[i-1];
    	}
    	return res;
    }
}
