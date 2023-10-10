package LaiOffer;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode addListNode(int[] array) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;

        for (int i = 0; i < array.length; i++) {
            dummy.next = new ListNode(array[i]);
            dummy = dummy.next;
        }

        return res.next;
    }

    public void printListNode(ListNode head) {
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + " -> ");
            } else {
                System.out.print(head.val);
            }

            head = head.next;
        }
    }
}
