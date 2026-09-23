package com.williamtrindade.LC3875ConstructUniformParityArrayI;

class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean hasOdd = false;
        boolean hasEven = false;

        for (int num : nums1) {
            if (num % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
        }

        // 1. Se todos forem pares (!hasOdd), é TRUE.
        // 2. Se houver pelo menos um ímpar (hasOdd), também é TRUE.
        return !hasOdd || hasOdd;
    }
}