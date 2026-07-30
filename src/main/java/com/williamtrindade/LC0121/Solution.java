package com.williamtrindade.LC0121;

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            int todayPrice = prices[i];
            if (todayPrice < minPrice) {
                minPrice = todayPrice;
            } else {
                int todayProfit = todayPrice - minPrice;
                if (todayProfit > max) {
                    max = todayProfit;
                }
            }
        }
        return max;
    }
}