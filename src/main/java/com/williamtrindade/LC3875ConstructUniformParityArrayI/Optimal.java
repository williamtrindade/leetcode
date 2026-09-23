package com.williamtrindade.LC3875ConstructUniformParityArrayI;

/*
 * EXPLICAÇÃO MATEMÁTICA:
 * O problema nos permite fazer nums2[i] = nums1[i] - nums1[j].
 * Sabendo que a subtração de duas paridades diferentes resulta em ÍMPAR:
 *   - Par - Ímpar = Ímpar
 *   - Ímpar - Par = Ímpar
 *
 * Se o array original tiver apenas pares ou apenas ímpares, a paridade já é uniforme (basta copiar).
 * Se o array for misto (tiver pares e ímpares), podemos transformar QUALQUER número em ÍMPAR:
 *   - Se nums1[i] for Par: subtraímos um Ímpar dele -> vira Ímpar.
 *   - Se nums1[i] for Ímpar: mantemos o valor original -> continua Ímpar.
 *
 * Como o array possui números distintos, sempre haverá elementos diferentes para a subtração.
 * Portanto, sempre é possível deixar todos os elementos de nums2 com paridade ÍMPAR.
 * Logo, a resposta é sempre 'true' para qualquer entrada.
 */

class Optimal {
    public boolean canConstructUniformParityArray(int[] nums1) {
        // É sempre possível construir o vetor com paridade uniforme
        return true;
    }
}