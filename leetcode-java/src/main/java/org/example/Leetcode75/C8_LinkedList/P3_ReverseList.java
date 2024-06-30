package org.example.Leetcode75.C8_LinkedList;

public class P3_ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode x = reverseList(head);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = p;
            p = curr;
            curr = next;
        }

        return p;
    }
}
