package SwordAtOffer.LinkedList;

import java.util.*;

/**
 * 剑指Offer
 * JZ23 链表中环的入口结点
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null
 * n <= 10000, 1 <= 节点值 <= 10000
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ23 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using two pointers, one go two steps and one go only one step. If the list has a loop, two pointer
     * will finally meet at some point, then return the point they meet. Otherwise, return null.
     *
     * 快指针路程=a+(b+c)k+b ，k>=1  其中b+c为环的长度，k为绕环的圈数（k>=1,即最少一圈，不能是0圈，不然和慢指针走的一样长，矛盾）。
     * 慢指针路程=a+b
     * 快指针走的路程是慢指针的两倍，所以：
     * （a+b）*2=a+(b+c)k+b
     * 化简可得：
     * a=(k-1)(b+c)+c 这个式子的意思是：链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈环长度。其中k>=1,所以k-1>=0圈
     * 所以两个指针第一次相遇之后分别从链表头和相遇点出发按照每次一步走，最后一定相遇于环入口
     */
    //判断有没有环，返回相遇的地方
    public ListNode hasCycle(ListNode head) {
        //先判断链表为空的情况
        if (head == null)
            return null;
        //快慢双指针
        ListNode fast = head;
        ListNode slow = head;
        //如果没环快指针会先到链表尾
        while (fast != null && fast.next != null) {
            //快指针移动两步
            fast = fast.next.next;
            //慢指针移动一步
            slow = slow.next;
            //相遇则有环，返回相遇的位置
            if (fast == slow)
                return slow;
        }
        //到末尾说明没有环，返回null
        return null;
    }

    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        ListNode slow = hasCycle(pHead);
        //没有环
        if (slow == null)
            return null;
        //快指针回到表头
        ListNode fast = pHead;
        //再次相遇即是环入口
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * Method 2: Using map to read all the item in the node list. Each node in the node list will be put into
     * the map with count times. If count times become 2, then it is the start of the loop. Otherwise, it
     * will have an end with null value.
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode node = pHead;
        while (node != null) {
            map.put(node, map.getOrDefault(node, 0) + 1);
            if (map.get(node) == 2) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

}
