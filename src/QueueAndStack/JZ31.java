package QueueAndStack;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ31 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序
 * 假设压入栈的所有数字均不相等
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 1. 0 <= pushV.length == popV.length <= 1000
 * 2. -1000 <= pushV[i] <= 1000
 * 3. pushV 的所有数字均不相同
 */

public class JZ31 {

    /**
     * Method 1: Using auxiliary stack to do the read input and output compare. Add nodes from the push array and pop
     * nodes if the push node equal the pop node. Then do the compare.
     */
    public boolean IsPopOrder1(int[] pushA, int[] popA) {
        int n = pushA.length;
        //辅助栈
        Stack<Integer> s = new Stack<>();
        //遍历入栈的下标
        int j = 0;
        //遍历出栈的数组
        for (int i = 0; i < n; i++) {
            //入栈：栈为空或者栈顶不等于出栈数组
            while (j < n && (s.isEmpty() || s.peek() != popA[i])) {
                s.push(pushA[j]);
                j++;
            }
            //栈顶等于出栈数组
            if (s.peek() == popA[i])
                s.pop();
                //不匹配序列
            else
                return false;
        }
        return true;
    }

    /**
     * Method 2: Using array with index defining a stack to find the position and do the similar operation like the
     * first one. Based on the final result n equals to 0 or not to judge the true or false.
     */
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        //表示栈空间的大小，初始化为0
        int n = 0;
        //出栈序列的下标
        int j = 0;
        //对于每个待入栈的元素
        for(int num : pushA){
            //加入栈顶
            pushA[n] = num;
            //当栈不为空且栈顶等于当前出栈序列
            while(n >= 0 && pushA[n] == popA[j]){
                //出栈，缩小栈空间
                j++;
                n--;
            }
            n++;
        }
        //最后的栈是否为空
        return n == 0;
    }
}
