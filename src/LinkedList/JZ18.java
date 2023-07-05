package LinkedList;

import java.util.*;

/**
 * 剑指Offer
 * JZ18 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点
 * 1.此题对比原题有改动
 * 2.题目保证链表中节点的值互不相同
 * 3.该题只会输出返回的链表和结果做对比，所以若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * 0 <= 链表节点值 <= 10000, 0 <= 链表长度 <= 10000
 */

public class JZ18 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method: Check whether node value equals to the target value or not. If yes then do the deletion.
     */
    public ListNode deleteNode (ListNode head, int val) {
        //加入一个头节点
        ListNode res = new ListNode(0);
        res.next = head;
        //前序节点
        ListNode pre = res;
        //当前节点
        ListNode cur = head;
        //遍历链表
        while(cur != null){
            //找到目标节点
            if(cur.val == val){
                //断开连接
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        //返回去掉头节点
        return res.next;
    }


}
