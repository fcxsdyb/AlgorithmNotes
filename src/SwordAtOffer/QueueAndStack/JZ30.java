package SwordAtOffer.QueueAndStack;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ30 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的 min 函数，输入操作时保证 pop、top 和 min 函数操作时，栈中一定有元素
 * 此栈包含的方法有：
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 * 0 <= 操作数量 <= 300, 输入的元素的值的绝对值 <= 10000
 * 空间复杂度O(n), 时间复杂度O(1)
 */

public class JZ30 {

    /**
     * Method: s1 is the normal stack to record the data, s2 used to save the min value of the current s1 data state.
     */
    //用于栈的push 与 pop
    Stack<Integer> s1 = new Stack<Integer>();
    //用于存储最小min
    Stack<Integer> s2 = new Stack<Integer>();

    public void push(int node) {
        s1.push(node);
        //空或者新元素较小，则入栈
        if (s2.isEmpty() || s2.peek() > node)
            s2.push(node);
        else
            //重复加入栈顶
            s2.push(s2.peek());
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }

}
