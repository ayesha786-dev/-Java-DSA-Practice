package com.first;

public class BestTimeTobuy {
    public static int maxProfit(int[] prices) {
    	int max = 0;
    	int min = prices[0];
    	for(int i=0;i<prices.length;i++) {
    		int profit = prices[i]-min;
    		max = Math.max(max, profit);
    		min = Math.min(min, prices[i]);
    	}
    	
		return max;
    }
    public static void main(String[] args) {
    	int []prices = {7,1,5,3,6,4};
    	
    	System.out.println(maxProfit(prices));
	}
}
