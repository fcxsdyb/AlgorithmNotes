package LaiOffer.Class3_Queue_Stack_LinkedList;

import LaiOffer.ListNode;

/**
 * LinkedList Question 1: How to find the middle node of a linked list?
 */
public class LinkedList_FindMiddle {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(), node1 = new ListNode(10);
        dummy.next = node1;

        ListNode node2 = new ListNode(7);
        node1.next = node2;

        ListNode node3 = new ListNode(15);
        node2.next = node3;

        ListNode node4 = new ListNode(25);
        node3.next = node4;

        ListNode node5 = new ListNode(1);
        node4.next = node5;

        ListNode node6 = new ListNode(5);
        node5.next = node6;

        ListNode middle = findMiddle(dummy.next);
        System.out.println(middle.val);
    }

    private static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
