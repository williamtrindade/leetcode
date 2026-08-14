package com.williamtrindade.LC0121BestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max = 0;

        for (int todayPrice : prices) {
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