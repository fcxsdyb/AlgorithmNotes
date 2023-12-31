package SwordAtOffer.Other;

/**
 * 剑指Offer
 * JZ62 孩子们的游戏(圆圈中最后剩下的数)
 * 每年六一儿童节，牛客都会准备一些小礼物和小游戏去看望孤儿院的孩子们
 * 其中，有个游戏是这样的：首先，让 n 个小朋友们围成一个大圈，小朋友们的编号是0~n-1
 * 然后，随机指定一个数 m ，让编号为0的小朋友开始报数
 * 每次喊到 m-1 的那个小朋友要出列唱首歌，然后可以在礼品箱中任意的挑选礼物，并且不再回到圈中
 * 从他的下一个小朋友开始，继续0... m-1报数....这样下去....直到剩下最后一个小朋友，可以不用表演，并且拿到牛客礼品
 * 请你试着想下，哪个小朋友会得到这份礼品呢？
 * 0 <= n <= 5000, 1 <= m <= 10000
 * 空间复杂度O(1), 时间复杂度O(n)
 */

public class JZ62 {

    /**
     * Method 1: Recursion.
     */
    private int function(int n, int m) {
        if (n == 1)
            return 0;
        //递归
        int x = function(n - 1, m);
        //返回最后删除的那个元素
        return (m + x) % n;
    }

    public int LastRemaining_Solution1(int n, int m) {
        //没有小朋友的情况
        if (n == 0 || m == 0)
            return -1;
        return function(n, m);
    }

    /**
     * Method 2: Loop.
     */
    public int LastRemaining_Solution2(int n, int m) {
        //没有小朋友的情况
        if (n == 0 || m == 0)
            return -1;
        int x = 0;
        //从小到大，更新x
        for (int i = 2; i <= n; i++)
            x = (m + x) % i;
        return x;
    }

}
