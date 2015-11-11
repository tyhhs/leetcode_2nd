package com.tyh.code;

public class Best_Time_to_Buy_and_Sell_Stock_III {

	public static void main(String[] args) {
		int[] prices = {2,1,2,0,1};
		System.out.println(new Best_Time_to_Buy_and_Sell_Stock_III().maxProfit(prices));
	}
	public static int maxProfit(int[] prices) {
		int len = prices.length;
		if(len < 2) return 0;
		int[] forward = new int[len];
		int[] backward = new int[len];
		int min = prices[0];
		int max = prices[len-1];
		int totalMax = 0;
		//forward
		for(int i = 1; i < len; i++){
			forward[i] = Math.max(prices[i]-min, forward[i-1]);
			min = Math.max(min, prices[i]);
		}
		//backward
		for(int i = len-2; i >= 0; i--){
			backward[i] = Math.max(max-prices[i], backward[i+1]);
			max = Math.min(max, prices[i]);
		}
		//calculate total max
		for(int i = 0; i < len; i++){
			totalMax = Math.max(totalMax, forward[i]+backward[i]);
		}
		return totalMax;
	}
    public int maxProfit2(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}
