package Tree;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ33 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true ,否则返回 false
 * 假设输入的数组的任意两个数字都互不相同
 * 0 <= 节点数 <= 1000, 1 <= 节点上的值 <= 10^5 且各不相同
 * 空间复杂度O(n)，时间复杂度O(n^2)
 */

public class JZ33 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using stack to check the postorder traversal.
     */
    public boolean VerifySequenceOfBST1(int[] sequence) {
        // 处理序列为空情况
        if (sequence.length == 0) return false;
        Stack<Integer> s = new Stack<>();
        int root = Integer.MAX_VALUE;
        // 以根，右子树，左子树顺序遍历
        for (int i = sequence.length - 1; i >= 0; i--) {
            // 确定根后一定是在右子树节点都遍历完了，因此当前sequence未遍历的节点中只含左子树，左子树的节点如果>root则说明违背二叉搜索的性质
            if (sequence[i] > root) return false;
            // 进入左子树的契机就是sequence[i]的值小于前一项的时候，这时可以确定root
            while (!s.isEmpty() && s.peek() > sequence[i]) {
                root = s.pop();
            }
            // 每个数字都要进一次栈
            s.add(sequence[i]);
        }
        return true;
    }

    /**
     * Method 2: Using recursion to divide tree based on the postorder traversal. The nodes smaller than the root and
     * nodes larger than the root should be in sequence. Using this rule to judge whether it is valid or not.
     */
    public boolean VerifySequenceOfBST2(int[] sequence) {
        if (sequence.length == 0) return false;
        return order(sequence, 0, sequence.length - 1);
    }

    public boolean order(int[] sequence, int l, int r) {
        // 剩一个节点的时候 返回 true
        if (l >= r) return true;
        int j;
        int mid = sequence[r];

        // 找到左子树和右子树的分界点，j代表左子树的最后一个索引位置
        for (j = r; j >= l; j--) {
            int cur = sequence[j];
            if (cur < mid) break;
        }

        // 判断所谓的左子树中是否又不合法（不符合二叉搜索树）的元素
        for (int i = j; i >= l; i--) {
            int cur = sequence[i];
            if (cur > mid) return false;
        }
        return order(sequence, l, j) && order(sequence, j + 1, r - 1);
    }
}
