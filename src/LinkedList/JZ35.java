package LinkedList;

import java.util.*;

/**
 * 剑指Offer
 * JZ35 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点）
 * 请对此链表进行深拷贝，并返回拷贝后的头结点（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 示例:
 * 输入:{1,2,3,4,5,3,5,#,2,#}
 * 输出:{1,2,3,4,5,3,5,#,2,#}
 * 解析:我们将链表分为两段，前半部分{1,2,3,4,5}为ListNode，后半部分{3,5,#,2,#}是随机指针域表示。
 * 以上示例前半部分可以表示链表为的ListNode:1->2->3->4->5
 * 后半部分，3，5，#，2，#分别的表示为
 * 1的位置指向3，2的位置指向5，3的位置指向null，4的位置指向2，5的位置指向null
 */

public class JZ35 {

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * Method 1: Using hashtable as the design pattern to do the node list copy. Use hashmap to create same node for
     * each node as its value. First round creates all the node and second round add the random for each created node.
     */
    public RandomListNode Clone1(RandomListNode pHead) {
        //空节点直接返回
        if (pHead == null)
            return pHead;
        //添加一个头部节点
        RandomListNode res = new RandomListNode(0);
        //哈希表，key为原始链表的节点，value为拷贝链表的节点
        HashMap<RandomListNode, RandomListNode> mp = new HashMap<>();
        RandomListNode cur = pHead;
        RandomListNode pre = res;
        //遍历原始链表，开始复制
        while (cur != null) {
            //拷贝节点
            RandomListNode clone = new RandomListNode(cur.label);
            //用哈希表记录该节点下的拷贝节点
            mp.put(cur, clone);
            //连接
            pre.next = clone;
            pre = pre.next;
            //遍历
            cur = cur.next;
        }
        //遍历哈希表
        for (HashMap.Entry<RandomListNode, RandomListNode> entry : mp.entrySet()) {
            //原始链表中random为空
            if (entry.getKey().random == null)
                entry.getValue().random = null;
            else
                //将新链表的random指向哈希表中原始链表的random
                entry.getValue().random = mp.get(entry.getKey().random);
        }
        //返回去掉头
        return res.next;
    }

    /**
     * Method 2: Using two pointers. Copy each node in the list after itself. Then use two pointers to connect original
     * list and new list with two pointers jump two steps after one operation. Finally, cut off all the relationship
     * between original one and copy one.
     */
    public RandomListNode Clone(RandomListNode pHead) {
        //空节点直接返回
        if (pHead == null)
            return pHead;
        //添加一个头部节点
        RandomListNode cur = pHead;
        //遍历原始链表，开始复制
        while (cur != null) {
            //拷贝节点
            RandomListNode clone = new RandomListNode(cur.label);
            //将新节点插入到被拷贝的节点后
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        cur = pHead;
        RandomListNode clone = pHead.next;
        RandomListNode res = pHead.next;
        //连接新链表的random节点
        while (cur != null) {
            //跟随前一个连接random
            if (cur.random == null)
                clone.random = null;
            else
                //后一个节点才是拷贝的
                clone.random = cur.random.next;
            //cur.next必定不为空
            cur = cur.next.next;
            //检查末尾节点
            if (clone.next != null)
                clone = clone.next.next;
        }
        cur = pHead;
        clone = pHead.next;
        //拆分两个链表
        while (cur != null) {
            //cur.next必定不为空
            cur.next = cur.next.next;
            cur = cur.next;
            //检查末尾节点
            if (clone.next != null)
                clone.next = clone.next.next;
            clone = clone.next;
        }
        return res;
    }

}
