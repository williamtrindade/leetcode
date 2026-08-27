package com.williamtrindade.LC0560SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // A soma 0 já apareceu 1 vez (antes do loop começar)
        int sum = 0;
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Se o (sum - k) já existe, somamos a quantidade de vezes que ele ocorreu
            if (map.containsKey(sum - k)) {
                ret += map.get(sum - k);
            }

            // Atualiza a frequência do sum atual no map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ret;
    }
}