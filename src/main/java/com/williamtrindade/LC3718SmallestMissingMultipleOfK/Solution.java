package com.williamtrindade.LC3718SmallestMissingMultipleOfK;

import java.util.HashSet;

class Solution {
    public int missingMultiple(int[] nums, int k) {
        // Space: O(n)
        HashSet<Integer> set = new HashSet<>();

        // Time: O(n)
        for(int n: nums) {
            if (n%k == 0) set.add(n);
        }
        int ans = k;
        while (set.contains(ans)) {
            ans += k;
        }
        return ans;
    }
}