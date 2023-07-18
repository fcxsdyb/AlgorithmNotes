package SwordAtOffer.DynamicProgramming;

import java.lang.*;

/**
 * 剑指Offer
 * JZ47 礼物的最大价值
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值
 * 请计算你最多能拿到多少价值的礼物？
 * 如输入这样的一个二维数组，
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 那么路径 1→3→5→2→1 可以拿到最多价值的礼物，价值为12
 * 0 <= grid.length <= 200, 0 <= grid[0].length <= 200
 */

public class JZ47 {

    /**
     * Method 1: Using dynamic programming finding the local optimal solution.
     */
    public int maxValue1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //第一列只能来自上方
        for (int i = 1; i < m; i++)
            grid[i][0] += grid[i - 1][0];
        //第一行只能来自左边
        for (int i = 1; i < n; i++)
            grid[0][i] += grid[0][i - 1];
        //遍历后续每一个位置
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                //增加来自左边的与上边的之间的较大值
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
        return grid[m - 1][n - 1];
    }

    /**
     * Method 2: Recursion. From the end to the start point, using reverse thinking.
     */
    private int recursion(int[][] grid, int m, int n, int[][] dp) {
        //到达起点
        if (m == 0 && n == 0) {
            dp[0][0] = grid[0][0];
            return grid[0][0];
        }
        //两个边界
        if (m == 0)
            dp[0][n] = grid[0][n] + recursion(grid, m, n - 1, dp);
        if (n == 0)
            dp[m][0] = grid[m][0] + recursion(grid, m - 1, n, dp);
        //如果有值可以直接返回
        if (dp[m][n] == 0)
            //递归求左边或者上边的最大值
            dp[m][n] = grid[m][n] + Math.max(recursion(grid, m - 1, n, dp), recursion(grid, m, n - 1, dp));
        return dp[m][n];
    }

    public int maxValue2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //用于记忆递归过程中的值
        int[][] dp = new int[m][n];
        return recursion(grid, m - 1, n - 1, dp);
    }

}
