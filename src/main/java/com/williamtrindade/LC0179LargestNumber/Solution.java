package com.williamtrindade.LC0179LargestNumber;

import java.util.Arrays;

/*
 * Complexidade de Tempo: O(N log N * K)
 * - N é a quantidade de elementos no array 'nums'.
 * - K é o comprimento máximo das strings (número de dígitos).
 * - A ordenação (TimSort) realiza O(N log N) comparações.
 * - Em cada comparação, fazemos (a+b) e (b+a), que leva tempo O(K)
 *   para concatenar e comparar os caracteres.
 *
 * Complexidade de Espaço: O(N * K)
 * - O(N * K) para armazenar o array de strings 'numStrings'.
 * - O(N * K) para o StringBuilder armazenar a string final.
 * - O TimSort do Java também usa O(N) de espaço auxiliar na memória.
 */
class Solution {

    public String largestNumber(int[] nums) {
        // Convert each integer to a string
        String[] numStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrings[i] = Integer.toString(nums[i]);
        }

        // Sort strings based on concatenated values
        Arrays.sort(numStrings, (a, b) -> (b + a).compareTo(a + b));

        // Handle the case where the largest number is zero
        if (numStrings[0].equals("0")) {
            return "0";
        }

        // Concatenate sorted strings to form the largest number
        StringBuilder largestNum = new StringBuilder();
        for (String numStr : numStrings) {
            largestNum.append(numStr);
        }

        return largestNum.toString();
    }
}