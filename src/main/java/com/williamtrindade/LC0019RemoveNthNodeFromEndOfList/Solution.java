package com.williamtrindade.LC0019RemoveNthNodeFromEndOfList;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 1. Cria um nó falso que aponta para o head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy; // Este é o seu nodeI
        ListNode fast = dummy; // Este é o seu nodeJ
        
        // 2. Avança o fast 'n + 1' passos à frente
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // 3. Move os dois juntos até o fast passar do último nó da lista
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // 4. O slow agora está EXATAMENTE um nó antes do alvo; fazemos a ponte
        slow.next = slow.next.next;
        
        // Retorna dummy.next, o que resolve o problema caso o head original tenha sido deletado
        return dummy.next;
    }
}
