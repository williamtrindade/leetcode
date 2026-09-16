package com.williamtrindade.LC0209MinimumSizeSubarraySum;

/**
 * Finds the minimum length of a contiguous subarray whose sum is greater than or equal to the target.
 * Uses the Sliding Window technique to expand and shrink the window dynamically.
 *
 * Time Complexity: O(N)
 * Even with a nested loop, both left and right pointers only move forward.
 * Each element is visited at most twice, resulting in linear time.
 *
 * Space Complexity: O(1)
 * No extra data structures are used, only a few integer variables.
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minRangeLen = Integer.MAX_VALUE;

        // O 'right' expande a janela continuamente
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // O 'left' encolhe a janela enquanto a soma for válida
            while (currentSum >= target) {
                minRangeLen = Math.min(minRangeLen, right - left + 1);
                currentSum -= nums[left];
                left++;
            }
        }

        return minRangeLen == Integer.MAX_VALUE ? 0 : minRangeLen;
    }
}