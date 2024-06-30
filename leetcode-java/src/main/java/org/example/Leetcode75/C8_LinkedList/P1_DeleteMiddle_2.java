package org.example.Leetcode75.C8_LinkedList;

public class P1_DeleteMiddle_2 {

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

        deleteMiddle(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    private static ListNode deleteMiddle(ListNode head) {
        if(head.next == null){
            return null;
        }
        if(head.next.next == null){
            head.next = null;
            return head;
        }

        ListNode mid = head;
        ListNode curr = head.next.next;
        while (curr != null && curr.next != null) {
            curr = curr.next.next;
            mid = mid.next;
        }

        mid.next = mid.next.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


