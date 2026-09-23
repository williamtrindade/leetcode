package com.williamtrindade.LC567PermutationInString;

import java.util.Arrays;

class OptimalSolution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int[] check1 = new int[26];
        int[] check2 = new int[26];

        if (len1 > len2) return false;

        for (int i = 0; i < len1; i++) {
            check1[s1.charAt(i) - 'a']++;
            check2[s2.charAt(i) - 'a']++;
        }

        for (int j = len1; j < len2; j++) {
            if (Arrays.equals(check1, check2)) return true;

            check2[s2.charAt(j) - 'a']++;
            check2[s2.charAt(j - len1) - 'a']--;
        }
        return (Arrays.equals(check1, check2));
    }
}