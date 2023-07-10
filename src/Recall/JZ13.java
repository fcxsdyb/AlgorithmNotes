package Recall;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ13 机器人的运动范围
 * 地上有一个 rows 行和 cols 列的方格。坐标从 [0,0] 到 [rows-1,cols-1]
 * 一个机器人从坐标 [0,0] 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 threshold 的格子
 * 0 <= n, m <= 20, 1 <= len <= 25
 */

public class JZ13 {

    /**
     * Method 1: DFS. Finding all the possible result based on each node in the given area. Judge whether a node is fit
     * for the requirement and check the other four direction nodes. If one node is checked, give a sign.
     */
    //记录遍历的四个方向
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    //记录答案
    int res = 0;

    //计算一个数字的每个数之和
    int cal(int n) {
        int sum = 0;
        //连除法算出每一位
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

    //深度优先搜索dfs
    void dfs(int i, int j, int rows, int cols, int threshold, boolean[][] vis) {
        //越界或者已经访问过
        if (i < 0 || i >= rows || j < 0 || j >= cols || vis[i][j] == true)
            return;
        //行列和数字相加大于threshold，不可取
        if (cal(i) + cal(j) > threshold)
            return;
        res += 1;
        //标记经过的位置
        vis[i][j] = true;
        //上下左右四个方向搜索
        for (int k = 0; k < 4; k++)
            dfs(i + dir[k][0], j + dir[k][1], rows, cols, threshold, vis);
    }

    public int movingCount1(int threshold, int rows, int cols) {
        //判断特殊情况
        if (threshold <= 0)
            return 1;
        //标记某个格子没有被访问过
        boolean[][] vis = new boolean[rows][cols];
        dfs(0, 0, rows, cols, threshold, vis);
        return res;
    }

    /**
     * Method 2: BFS. Checking all the nodes whether they meet for the rule, then adding to the queue. After judging
     * adding new one to the queue.
     */
    public int movingCount2(int threshold, int rows, int cols) {
        //判断特殊情况
        if (threshold <= 0)
            return 1;
        //标记某个格子没有被访问过
        boolean[][] vis = new boolean[rows][cols];
        //记录答案
        int res = 0;
        Queue<ArrayList<Integer>> q = new LinkedList<ArrayList<Integer>>();
        //起点先入队列
        q.offer(new ArrayList<Integer>(Arrays.asList(0, 0)));
        vis[0][0] = true;
        while (!q.isEmpty()) {
            //获取符合条件的一步格子
            ArrayList<Integer> node = q.poll();
            res += 1;
            //遍历四个方向
            for (int i = 0; i < 4; i++) {
                int x = node.get(0) + dir[i][0];
                int y = node.get(1) + dir[i][1];
                //符合条件的下一步才进入队列
                if (x >= 0 && x < rows && y >= 0 && y < cols && vis[x][y] != true) {
                    if (cal(x) + cal(y) <= threshold) {
                        q.offer(new ArrayList<Integer>(Arrays.asList(x, y)));
                        vis[x][y] = true;
                    }
                }
            }
        }
        return res;
    }

}
