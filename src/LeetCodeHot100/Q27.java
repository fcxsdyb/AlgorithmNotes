package LeetCodeHot100;

/**
 * 62.不同路径
 */

public class Q27 {

    /**
     * 1.DP
     */
    public int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    /**
     * 2.BFS
     * 超时
     */
    public static int uniquePaths(int m, int n) {
        int[] count = new int[1];
        count[0] = 0;
        dfs(count, 0, 0, m, n);
        return count[0];
    }

    public static void dfs(int[] count, int startX, int startY, int targetX, int targetY) {
        if (startX == targetX - 1 && startY == targetY - 1) {
            count[0]++;
            return;
        }

        if (startX < targetX) {
            dfs(count, startX + 1, startY, targetX, targetY);
        }
        if (startY < targetY) {
            dfs(count, startX, startY + 1, targetX, targetY);
        }
    }

    public static void main(String[] args) {
        int a = uniquePaths(3, 2);
    }

}
