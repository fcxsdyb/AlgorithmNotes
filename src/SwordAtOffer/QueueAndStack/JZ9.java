package SwordAtOffer.QueueAndStack;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ9 用两个栈实现队列
 * 用两个栈来实现一个队列，使用n个元素来完成n次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能
 * 队列中的元素为int类型
 * 保证操作合法，即保证pop操作时队列内已有元素
 * n <= 1000
 * 空间复杂度O(n), 时间复杂度O(1)
 */

public class JZ9 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        //将第一个栈中内容弹出放入第二个栈中
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        //第二个栈栈顶就是最先进来的元素，即队首
        int res = stack2.pop();
        //再将第二个栈的元素放回第一个栈
        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        return res;
    }

}
