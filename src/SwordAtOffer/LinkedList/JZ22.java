package SwordAtOffer.LinkedList;

/**
 * 剑指Offer
 * JZ22 链表中倒数最后k个结点
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点
 * 如果该链表长度小于k，请返回一个长度为 0 的链表
 * 0 <= n <= 10^5, 0 <= ai <= 10^9, 0 <= k <= 10^9
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ22 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Based on the last k items, we can use two pointers which one is at the original start and one for
     * the k item start from the start point. As two pointers keep going at the same time, when the second pointer
     * meet the end, the first item will have k item left.
     *
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail1(ListNode pHead, int k) {
        int n = 0;
        ListNode fast = pHead;
        ListNode slow = pHead;
        //快指针先行k步
        for (int i = 0; i < k; i++) {
            if (fast != null)
                fast = fast.next;
                //达不到k步说明链表过短，没有倒数k
            else
                return slow = null;
        }
        //快慢指针同步，快指针先到底，慢指针指向倒数第k个
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * Method 2: Count the length n of the node list and then output all the items after n - k items.
     */
    public ListNode FindKthToTail2(ListNode pHead, int k) {
        int n = 0;
        ListNode p = pHead;
        //遍历链表，统计链表长度
        while (p != null) {
            n++;
            p = p.next;
        }
        //长度过小，返回空链表
        if (n < k)
            return null;
        p = pHead;
        //遍历n-k次
        for (int i = 0; i < n - k; i++)
            p = p.next;
        return p;
    }

}
