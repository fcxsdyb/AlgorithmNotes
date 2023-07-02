package LinkedList;

import java.util.*;

/**
 * 剑指Offer
 * JZ6 从尾到头打印链表
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）
 * 返回值保存在数组中
 * 链表长度大于等于0，小于等于10000
 */

public class JZ6 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using stack to load all the nodes in the ListNode since stack is FILO, we can use another
     * ListNode to store all the item in the stack.
     *
     * @param listNode head node for go through all the data save in the node structure
     * @return return the list with reverse order
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }


    /**
     * Method 2: Using recursion to find the deepest item and by the recursion mechanism, it will do the add
     * items and return one by one.
     *
     * @param head head node for go through all the data save in the node structure
     * @param res  return the list with reverse order
     */
    public void recursion(ListNode head, ArrayList<Integer> res) {
        if (head != null) {
            //先往链表深处遍历
            recursion(head.next, res);
            //再填充到数组就是逆序
            res.add(head.val);
        }
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //递归函数解决
        recursion(listNode, res);
        return res;
    }

}
