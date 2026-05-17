package com.williamtrindade.LC2357;

import java.util.HashSet;
import java.util.Set;

class OptimalSolution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);

        for (int n : nums) {
            set.add(n);
        }

        int counter = 0;
        for (int n: set) {
            if (n!=0) {
                counter ++;
            }
        }
        return counter;
    }
}