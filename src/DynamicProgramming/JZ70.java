package DynamicProgramming;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ70 矩形覆盖
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，从同一个方向看总共有多少种不同的方法？
 * 0 <= n <= 38
 * 空间复杂度O(1), 时间复杂度O(n)
 */

public class JZ70 {

    /**
     * Method: Divide the problem into small part, it is actually a Fibonacci Problem.
     */
    public int rectCover(int target) {
        //约定 n == 0 时，输出 0, 1时也只有一种
        if (target <= 2)
            return target;
        //f(n-1)+f(n-2)
        return rectCover(target - 1) + rectCover(target - 2);
    }

}
