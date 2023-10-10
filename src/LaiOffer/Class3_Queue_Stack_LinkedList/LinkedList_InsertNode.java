package LaiOffer.Class3_Queue_Stack_LinkedList;

import LaiOffer.ListNode;

/**
 * LinkedList Question 3: Insert a node in a sorted linked list.
 */
public class LinkedList_InsertNode {

    public static ListNode addNode(ListNode head, ListNode add) {
        if (head == null) {
            return add;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        if (add.val < head.val) {
            dummy.next = add;
            add.next = head;
            return dummy.next;
        }

        while (head != null && head.next != null) {
            if (head.val < add.val && head.next.val >= add.val) {
                ListNode next = head.next;
                head.next = add;
                add.next = next;
                return dummy.next;
            }
            head = head.next;
        }

        head.next = add;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode dummy = new ListNode(), node1 = new ListNode(1);
        dummy.next = node1;

        ListNode node2 = new ListNode(2);
        node1.next = node2;

        ListNode node3 = new ListNode(4);
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        node3.next = node4;

        ListNode node5 = new ListNode(7);
        node4.next = node5;

        ListNode node6 = new ListNode(10);
        node5.next = node6;

        ListNode start1 = addNode(dummy.next, new ListNode(-1));
        ListNode start2 = addNode(start1, new ListNode(6));
        ListNode start3 = addNode(start2, new ListNode(12));

        while (start3 != null) {
            if (start3.next != null) {
                System.out.print(start3.val + " -> ");
            } else {
                System.out.print(start3.val);
            }

            start3 = start3.next;
        }
    }

}
