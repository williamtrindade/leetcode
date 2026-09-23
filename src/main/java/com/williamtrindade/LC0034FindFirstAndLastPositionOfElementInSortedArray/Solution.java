package com.williamtrindade.LC0034FindFirstAndLastPositionOfElementInSortedArray;

class Solution {

    /**
     * Finds the starting and ending position of a given target value in a sorted array.
     * The algorithm runs in O(log n) runtime complexity.
     *
     * @param nums   The array of integers, sorted in non-decreasing order.
     * @param target The integer value to search for.
     * @return       An array of length 2 containing the [first_occurrence, last_occurrence] indices.
     *               If the target is not found, returns [-1, -1].
     */
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};

        int first = binSearch(nums, target, true);
        ret[0] = first;

        if (first == -1) {
            // Target does not exist in the array
            return ret;
        }

        int last = binSearch(nums, target, false);
        ret[1] = last;

        return ret;
    }

    /**
     * Performs a modified binary search to find either the first or the last occurrence
     * of a target number.
     *
     * @param nums   The array of integers, sorted in non-decreasing order.
     * @param target The integer value to search for.
     * @param first  If true, searches for the first occurrence. If false, searches for the last.
     * @return       The index of the requested occurrence, or -1 if the target is not found.
     */
    public int binSearch(int[] nums, int target, boolean first) {
        int left = 0;
        int right = nums.length;
        int res = -1;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                res = middle;
                if (first) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
                continue;
            }

            if (target < nums[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return res;
    }
}