package LaiOffer.Class3_Queue_Stack_LinkedList;

import LaiOffer.ListNode;

/**
 * LinkedList Question 4: How to merge two sorted linked list into one long sorted linked list?
 */
public class LinkedList_MergeTwoLinkedList {

    public static void main(String[] args) {
        ListNode linkedlist = new ListNode();

        ListNode dummy1, dummy2;
        int[] array1 = {1, 3, 4, 5, 6, 9};
        int[] array2 = {2, 4, 5, 7, 10, 11};
        dummy1 = linkedlist.addListNode(array1);
        dummy2 = linkedlist.addListNode(array2);

        ListNode res = mergeTwoLinkedList(dummy1, dummy2);
        linkedlist.printListNode(res);
    }

    private static ListNode mergeTwoLinkedList(ListNode dummy1, ListNode dummy2) {
        if (dummy1 == null && dummy2 != null) {
            return dummy2;
        } else if (dummy1 != null && dummy2 == null) {
            return dummy1;
        }

        ListNode res = new ListNode();
        ListNode dummy = res;
        while (dummy1 != null && dummy2 != null) {
            if (dummy1.val <= dummy2.val) {
                res.next = new ListNode(dummy1.val);
                dummy1 = dummy1.next;
            } else {
                res.next = new ListNode(dummy2.val);
                dummy2 = dummy2.next;
            }
            res = res.next;
        }

        if (dummy1 == null) {
            res.next = dummy2;
        }
        if (dummy2 == null) {
            res.next = dummy1;
        }

        return dummy.next;
    }

}
