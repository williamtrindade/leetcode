package com.williamtrindade.LC0011;

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length-1;
        while (i < j) {
            int amountInThisCase = Math.min(height[i], height[j]) * (j-i);
            if (amountInThisCase > max) {
                max = amountInThisCase;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}