package com.williamtrindade.LC0283;

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        while(j < nums.length) {
            if (nums[j] != 0) {
                int aux = nums[i];
                nums[i] = nums[j];
                nums[j] = aux;
                i++;
            }
            j++;
        }
    }
}