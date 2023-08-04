package LeetCodeHot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 437.路径总和III
 */

public class Q87 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Long, Long> preSumMap;
    Long target;

    public int pathSum(TreeNode root, int targetSum) {
        preSumMap = new HashMap<>();
        target = Long.valueOf(targetSum);
        preSumMap.put(0L, 1L);

        return recur(root, 0L).intValue();
    }

    private Long recur(TreeNode root, Long preSum) {   //返回以root为根节点的符合题目条件的答案个数
        if (root == null) return 0L;
        Long curNum = root.val + preSum;
        Long res = preSumMap.getOrDefault(Long.valueOf(curNum - target), 0L);
        preSumMap.put(Long.valueOf(curNum), preSumMap.getOrDefault(curNum, 0L) + 1); //更新前缀和

        res += recur(root.left, curNum);        //过去答案
        res += recur(root.right, curNum);

        preSumMap.put(Long.valueOf(curNum), preSumMap.get(curNum) - 1);
        return res;

    }

}
