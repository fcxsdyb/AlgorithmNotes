package LaiOffer.Class7_Midterm;

import LaiOffer.ListNode;

/**
 * Question 1. Reverse a singly LinkedList. (two approaches, iterative + recursive)
 */
public class ReverseLinkedList {

    /**
     * Iterative
     * <p>
     * Time Complexity = O(n)
     * Space Complexity = O(1)
     *
     * @param head
     * @return
     */
    public static ListNode reverseI(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    /**
     * Recursive
     * <p>
     * Time Complexity = O(n)
     * Space Complexity = O(n)
     *
     * @param head
     * @return
     */
    public static ListNode reverseII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseII(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(), node1 = new ListNode(2);
        dummy.next = node1;

        ListNode node2 = new ListNode(5);
        node1.next = node2;

        ListNode node3 = new ListNode(10);
        node2.next = node3;

        ListNode node4 = new ListNode(7);
        node3.next = node4;

        ListNode node5 = new ListNode(21);
        node4.next = node5;

        ListNode ans1 = reverseI(dummy.next);
        while (ans1 != null) {
            if (ans1.next != null) {
                System.out.print(ans1.val + " -> ");
            } else {
                System.out.print(ans1.val);
            }

            ans1 = ans1.next;
        }

        ListNode ans2 = reverseII(dummy.next);
        while (ans2 != null) {
            if (ans2.next != null) {
                System.out.print(ans2.val + " -> ");
            } else {
                System.out.print(ans2.val);
            }

            ans2 = ans2.next;
        }
    }

}
