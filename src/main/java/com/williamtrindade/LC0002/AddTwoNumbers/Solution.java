package com.williamtrindade.LC0002.AddTwoNumbers;

/*
  SC and TC - O(max(n,m))
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode head = res;

        int carry = 0;
        while (l1!=null || l2!=null) {
            int sum = 0;
            if (l1!=null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2!=null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            sum = sum + carry;

            // Math handles the logic without an if-statement
            carry = sum / 10;
            res.next = new ListNode(sum % 10);

            res = res.next;
        }
        if (carry > 0) {
            res.next = new ListNode(carry);
        }

        return head.next;
    }
}

