package SwordAtOffer.LinkedList;

/**
 * 剑指Offer
 * JZ24 合并两个排序的链表
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的
 * 0 <= n <= 1000, -1000 <= 节点值 <= 1000
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ25 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using two pointers to compare val in two list and add the smaller one into the final return list.
     * You have to check whether list is empty or not. Also, you can directly add the rest list if one list ends.
     *
     * @param list1
     * @param list2
     * @return return the sorted list
     */
    public ListNode Merge1(ListNode list1, ListNode list2) {
        //一个已经为空了，直接返回另一个
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        //加一个表头
        ListNode head = new ListNode(0);
        ListNode cur = head;
        //两个链表都要不为空
        while (list1 != null && list2 != null) {
            //取较小值的节点
            if (list1.val <= list2.val) {
                cur.next = list1;
                //只移动取值的指针
                list1 = list1.next;
            } else {
                cur.next = list2;
                //只移动取值的指针
                list2 = list2.next;
            }
            //指针后移
            cur = cur.next;
        }
        //哪个链表还有剩，直接连在后面
        if (list1 != null)
            cur.next = list1;
        else
            cur.next = list2;
        //返回值去掉表头
        return head.next;
    }

    /**
     * Method 2: Using recursion to separate the divide method. Compare and return smaller one.
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        //一个已经为空了，返回另一个
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        //先用较小的值的节点
        if (list1.val <= list2.val) {
            //递归往下
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            //递归往下
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

}
