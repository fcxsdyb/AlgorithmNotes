package LaiOffer.Class3_Queue_Stack_LinkedList;

import LaiOffer.ListNode;

/**
 * LinkedList Question 2: How to judge a linked list has a cycle or not? And how to find the cross point?
 */
public class LinkedList_IsCyclic {

    private static ListNode isCyclic(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }

        return null;
    }
    
}
