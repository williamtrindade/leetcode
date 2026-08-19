package com.williamtrindade.LC0704BinarySearch;

class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            int midVal = nums[mid];

            if (midVal == target) return mid;

            if (target > midVal) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}