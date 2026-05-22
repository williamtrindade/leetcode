package com.williamtrindade.LC0767ReorganizeString;

import java.util.PriorityQueue;

public class OptimalSolution { public String reorganizeString(String s) {
    int sLength = s.length();
    int[] counts = new int[26];

    // 1. Contar as frequências das letras
    for (int i = 0; i < sLength; i++) {
        counts[s.charAt(i) - 'a']++;
    }

    // 2. Criar a Max-Heap baseada na frequência do array
    PriorityQueue<Character> priorityQueue = new PriorityQueue<>(
            (a, b) -> counts[b - 'a'] - counts[a - 'a']
    );

    // 3. Adicionar as letras existentes e validar a regra de impossibilidade
    int maxLimit = (sLength + 1) / 2;
    for (int i = 0; i < 26; i++) {
        if (counts[i] > 0) {
            if (counts[i] > maxLimit) {
                return ""; // Impossível reorganizar
            }
            priorityQueue.add((char) ('a' + i));
        }
    }

    StringBuilder sb = new StringBuilder();
    Character block = null; // Segura o caractere usado para não repetir em seguida

    // 4. Montar a string alternando os caracteres
    while (!priorityQueue.isEmpty()) {
        char current = priorityQueue.poll();
        sb.append(current);
        counts[current - 'a']--;

        // Se tínhamos um caractere bloqueado da rodada anterior,
        // ele agora pode voltar para a fila pois já colocamos um separador
        if (block != null && counts[block - 'a'] > 0) {
            priorityQueue.add(block);
        }

        // Bloqueia o caractere atual para a próxima rodada (se ainda restar cópias dele)
        if (counts[current - 'a'] > 0) {
            block = current;
        } else {
            block = null; // Não há o que bloquear se ele acabou
        }
    }

    return sb.toString();
}

}
