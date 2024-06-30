package org.example.Leetcode75.C8_LinkedList;

public class P2_OddEven {

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

        ListNode x = oddEvenList(head);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }
    }

    private static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        ListNode odd, even_head, curr, even_tail;
        odd = head;
        even_head = head.next;
        even_tail = head.next;
        curr = head.next;

        int i = 1;

        while (curr.next != null) {
            curr = curr.next;
            if (i % 2 == 0) {
                even_tail.next = curr;
                even_tail = even_tail.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }
            i++;
        }

        odd.next = even_head;
        even_tail.next = null;

        // while (head.next != null) {
        //     System.out.print(head.val + ", ");
        //     head = head.next;
        // }
        return head;
    }
}

