package com.williamtrindade.LC0767ReorganizeString;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FirstSolution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int sLength = s.length();

        // Add letters on the map
        for (int i = 0; i < sLength; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        // early return if the rule is not passed
        for (Map.Entry<Character, Integer> mapItem : map.entrySet()) {
            // if n > ((n.length + 1) / 2)
            if (mapItem.getValue() > ((sLength + 1) / 2)) {
                return "";
            }
        }

        // mount the possible return string

        PriorityQueue<Character> priorityQueue =
                new PriorityQueue<>(
                        (a, b) -> map.get(b) - map.get(a)
                );

        priorityQueue.addAll(map.keySet());


        StringBuilder sb = new StringBuilder();

        while (!priorityQueue.isEmpty()) {
            Character first = priorityQueue.poll();
            Character second = null;
            if (map.get(first) > 0) {
                sb.append(first);
                map.put(first, map.get(first) - 1);
            }

            if (!priorityQueue.isEmpty()) {
                second = priorityQueue.poll();
                if (map.get(second) > 0) {
                    sb.append(second);
                    map.put(second, map.get(second) - 1);
                }
            }

            if (map.get(first) > 0) {
                priorityQueue.add(first);
            }

            if (second != null && map.get(second) > 0) {
                priorityQueue.add(second);
            }

        }
        return sb.toString();

    }
}
