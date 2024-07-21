package org.example.Leetcode75.C8_LinkedList;

public class MaxTwinSum {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(maxTwinSum(head));
    }

    public static int maxTwinSum(ListNode head) {
        int max_sum = 0;

        ListNode current = head;
        ListNode mid = head;
        ListNode prev = null;


        while (current != null && current.next != null) {
            current = current.next.next;
            mid = mid.next;
        }

        while (mid != null) {
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        ListNode a = head;
        ListNode b = prev;

        while (a != null && b != null) {
            max_sum = Math.max(a.val + b.val, max_sum);
            a = a.next;
            b = b.next;
        }

        return max_sum;
    }
}
