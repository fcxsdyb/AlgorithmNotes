package SwordAtOffer.LinkedList;

/**
 * 剑指Offer
 * JZ52 两个链表的第一个公共结点
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * n <= 1000
 * 空间复杂度O(1)，时间复杂度O(n)
 */

public class JZ52 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Let two pointers traverse a node list and another one at the same time, if they have the shared
     * part, once they have the same item, return it. Otherwise, return null.
     *
     * @param pHead1
     * @param pHead2
     * @return return the public part
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        //其中有一个为空，则不能有公共节点，返回null
        if(pHead1 == null || pHead2 == null)
            return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //相当于遍历两次两个链表所有值
        while(p1 != p2){
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

    /**
     * Method 2: Count the length for both list, deduct the longer length then compare each item.
     */
    //计算链表长度的函数
    public int ListLenth(ListNode pHead){
        ListNode p = pHead;
        int n = 0;
        while(p != null){
            n++;
            p = p.next;
        }
        return n;
    }
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        int p1 = ListLenth(pHead1);
        int p2 = ListLenth(pHead2);
        //当链表1更长时，链表1指针先走p1-p2步
        if(p1 >= p2){
            int n = p1 - p2;
            for(int i = 0; i < n; i++){
                pHead1 = pHead1.next;
            }
            //两个链表同时移动，直到有公共节点时停下
            while((pHead1 != null) && (pHead2 != null) && (pHead1 != pHead2)){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        //反之，则链表2先行p2-p1步
        else{
            int n = p2 - p1;
            for(int i = 0; i < n; i++){
                pHead2 = pHead2.next;
            }
            //两个链表同时移动，直到有公共节点时停下
            while((pHead1 != null) && (pHead2 != null) && (pHead1 != pHead2)){
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return pHead1;
    }

}
