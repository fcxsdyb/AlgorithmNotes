package Other;

import java.util.*;
import java.lang.*;
import java.math.*;

/**
 * 剑指Offer
 * JZ83 剪绳子（进阶版）
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长的 m 段（ m 、 n 都是整数， n > 1 并且 m > 1 ， m <= n ）
 * 每段绳子的长度记为 k[1],...,k[m] 。请问 k[1]*k[2]*...*k[m] 可能的最大乘积是多少？
 * 例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时得到的最大乘积是 18
 * 由于答案过大，请对 998244353 取模。
 * 2 <= n <= 10^14
 * 空间复杂度O(1), 时间复杂度O(log n)
 */

public class JZ83 {

    /**
     * Method: Using Bits Operation.
     */
    private long mod = 998244353;

    //快速乘法
    private long fast(long x, long y) {
        long res = 0;
        x %= mod;
        y %= mod;
        while (y != 0) {
            if ((y & 1L) != 0) {
                //加法代替乘法，防止越界
                res += x;
                if (res >= mod)
                    res -= mod;
            }
            y = y >> 1;
            x = x << 1;
            if (x >= mod)
                x -= mod;
        }
        return res;
    }

    //快速幂
    long Pow(long x, long y) {
        long res = 1;
        while (y != 0) {
            //可以再往上乘一个
            if ((y & 1L) != 0)
                res = fast(res, x);
            //叠加
            x = fast(x, x);
            //减少乘次数
            y = y >> 1;
        }
        return res;
    }

    public long cutRope1(long number) {
        //不超过3直接计算
        if (number <= 3)
            return number - 1;
        //能整除3
        if (number % 3 == 0)
            return Pow(3, number / 3);
            //最后剩余1
        else if (number % 3 == 1)
            //4*3^{n-1}
            return fast(Pow(3, number / 3 - 1), 4);
            //最后剩余2
        else
            //2*3^n
            return fast(Pow(3, number / 3), 2);
    }

}
