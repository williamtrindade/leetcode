package com.williamtrindade.LC0075SortColors;

class Solution {

    static void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    static int[] quickSort(int[] ar, int left, int right) {
        if (left >= right) return ar;
        int pivot = ar[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (ar[j] <= pivot) {
                i++;
                int aux = ar[j]; ar[j] = ar[i]; ar[i] = aux;
            }
        }
        i++;
        int aux = ar[right]; ar[right] = ar[i]; ar[i] = aux;
        ar = quickSort(ar, left, i - 1);
        ar = quickSort(ar, i + 1, right);
        return ar;
    }
}