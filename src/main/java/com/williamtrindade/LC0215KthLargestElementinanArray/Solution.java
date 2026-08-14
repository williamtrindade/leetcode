package com.williamtrindade.LC0215KthLargestElementinanArray;

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Cria um Max-Heap (o maior elemento fica na head)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Adiciona todos os elementos (Tempo: O(N log N))
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Remove os K-1 maiores elementos (Tempo: O(K log N))
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        // A head agora contém o K-ésimo maior elemento
        return maxHeap.poll();
    }
}