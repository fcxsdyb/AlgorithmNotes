package SwordAtOffer.LinkedList;

import java.util.*;

/**
 * 剑指Offer
 * JZ76 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
 * 例如，链表 1->2->3->3->4->4->5  处理后为 1->2->5
 * 链表长度满足 0 <= n <= 1000, 值满足 1 <= val <= 1000
 * 空间复杂度O(n)，时间复杂度O(n)
 */

public class JZ76 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Directly check whether linked two nodes has the same value. If two value is the same, record the value
     * and compare with the next one, discard all these nodes until finding different value node.
     *
     * @return Since we initial a node with 0, we need to discard it.
     */
    public ListNode deleteDuplication1(ListNode pHead) {
        //空链表
        if (pHead == null)
            return null;
        ListNode res = new ListNode(0);
        //在链表前加一个表头
        res.next = pHead;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            //遇到相邻两个节点值相同
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                //将所有相同的都跳过
                while (cur.next != null && cur.next.val == temp)
                    cur.next = cur.next.next;
            } else
                cur = cur.next;
        }
        //返回时去掉表头
        return res.next;
    }

    /**
     * Method 2: Using hashtable to record the times for each value occurs. If records is larger than 1, then delete
     * this node.
     */
    public ListNode deleteDuplication2(ListNode pHead) {
        //空链表
        if (pHead == null)
            return null;
        Map<Integer, Integer> mp = new HashMap<>();
        ListNode cur = pHead;
        //遍历链表统计每个节点值出现的次数
        while (cur != null) {
            if (mp.containsKey(cur.val))
                mp.put(cur.val, (int) mp.get(cur.val) + 1);
            else
                mp.put(cur.val, 1);
            cur = cur.next;
        }
        ListNode res = new ListNode(0);
        //在链表前加一个表头
        res.next = pHead;
        cur = res;
        //再次遍历链表
        while (cur.next != null) {
            //如果节点值计数不为1
            if (mp.get(cur.next.val) != 1)
                //删去该节点
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        //去掉表头
        return res.next;
    }

}
