package com.williamtrindade.LC0021;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Casos base para otimização (opcional, mas recomendado)
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Criação do "dummy node" para facilitar a montagem
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // O loop cuida de TODAS as comparações, desde o primeiro elemento
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Anexa o que sobrou da lista que não ficou vazia
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Retorna o início real da lista, pulando o dummy node
        return dummy.next;
    }
}