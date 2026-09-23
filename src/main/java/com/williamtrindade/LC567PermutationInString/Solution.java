package com.williamtrindade.LC567PermutationInString;

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // 1. Conta a frequência da string s1 e preenche a primeira "janela" de s2
        for (int i = 0; i < n1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // 2. Desliza a janela ao longo do restante de s2
        for (int i = n1; i < n2; i++) {
            // Se as frequências baterem, achamos um anagrama válido
            if (Arrays.equals(count1, count2)) {
                return true;
            }

            // Adiciona o novo caractere que entra na janela (pela direita)
            count2[s2.charAt(i) - 'a']++;

            // Remove o caractere que acabou de sair da janela (pela esquerda)
            // pega pela distancia
            count2[s2.charAt(i - n1) - 'a']--;
        }

        // 3. Verifica a última janela (caso o anagrama esteja no exato final da string)
        return Arrays.equals(count1, count2);
    }
}