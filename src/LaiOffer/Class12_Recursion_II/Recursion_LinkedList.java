package LaiOffer.Class12_Recursion_II;

import LaiOffer.ListNode;

/**
 * Recursion Question 3
 */
public class Recursion_LinkedList {

    /**
     * 3.1 Recursion reverse linked ist
     * <p>
     * 3.2 Reverse a linked list (pair by pair)
     * 3 -> 2 -> 4 -> 6 -> 7
     * =>
     * 2 -> 3 -> 6 -> 4 -> 7
     */

    public static void main(String[] args) {
        ListNode dummy = new ListNode(), node1 = new ListNode(3);
        dummy.next = node1;

        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(4);
        node2.next = node3;

        ListNode node4 = new ListNode(6);
        node3.next = node4;

        ListNode node5 = new ListNode(7);
        node4.next = node5;

        ListNode res = reversePair(dummy.next);
        res.printListNode(res);
    }

    private static ListNode reversePair(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode temp = node.next;
        node.next = reversePair(node.next.next);
        temp.next = node;
        return temp;
    }

}
