package com.williamtrindade.LC0325;

import java.util.HashMap;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k == sum) {
                maxLen = Math.max(maxLen, i+1);
            }

            if (hashMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - hashMap.get(sum-k));
            }

            if (!hashMap.containsKey(sum)) {
                hashMap.put(sum, i);
            }
        }
        return maxLen;
    }
}