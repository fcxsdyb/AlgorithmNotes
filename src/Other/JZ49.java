package Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ49 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）
 * 例如6、8都是丑数，但14不是，因为它包含质因子7
 * 习惯上我们把1当做是第一个丑数
 * 求按从小到大的顺序的第 n 个丑数
 * 0 <= n <= 2000
 * 空间复杂度O(n), 时间复杂度O(n)
 */

public class JZ49 {

    /**
     * Method 1: Hashtable and Priority Queue.
     */
    public int GetUglyNumber_Solution1(int index) {
        //排除0
        if (index == 0)
            return 0;
        //要乘的因数
        int[] factors = {2, 3, 5};
        //去重
        HashMap<Long, Integer> mp = new HashMap<>();
        //小顶堆
        PriorityQueue<Long> pq = new PriorityQueue<>();
        //1先进去
        mp.put(1L, 1);
        pq.offer(1L);
        long res = 0;
        for (int i = 0; i < index; i++) {
            //每次取最小的
            res = pq.poll();
            for (int j = 0; j < 3; j++) {
                //乘上因数
                long next = (long) res * factors[j];
                //只取未出现过的
                if (!mp.containsKey(next)) {
                    mp.put(next, 1);
                    pq.offer(next);
                }
            }
        }
        return (int) res;
    }

    /**
     * Method 2: Dynamic Programming.
     */
    public int GetUglyNumber_Solution2(int index) {
        //1 2 3 4 5 6 8
        if (index <= 6)
            return index;   // 加快程序输出

        // 三个变量 后面有大作用！
        int i2 = 0, i3 = 0, i5 = 0;
        int[] res = new int[index];
        res[0] = 1;  // 第一个丑数为 1

        for (int i = 1; i < index; i++) {
            // 得到下一个丑数，三者中最小的
            res[i] = Math.min(res[i2] * 2, Math.min(res[i3] * 3, res[i5] * 5));
            /*第一次是 2、3、5比较，得到最小的是2*/
            /*第二次是 4、3、5比较，为什么是4了呢？因为上次2已经乘了一次了，所以接下去可以放的丑数在4、3、5之间*/
            // 所以开头的三个指针就是来标记2 3 5 乘的次数的
            if (res[i] == res[i2] * 2)
                i2++;
            if (res[i] == res[i3] * 3)
                i3++;
            if (res[i] == res[i5] * 5)
                i5++;
        }
        return res[index - 1];
    }
}
