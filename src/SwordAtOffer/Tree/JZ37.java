package SwordAtOffer.Tree;

import java.lang.*;

/**
 * 剑指Offer
 * JZ37 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树，不对序列化之后的字符串进行约束，但要求能够根据序列化之后的字符串重新构造出一棵与原二叉树相同的树
 * <p>
 * 二叉树的序列化(Serialize)是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存
 * 序列化可以基于先序、中序、后序、层序的二叉树等遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过某种符号表示空节点（#）
 * <p>
 * 二叉树的反序列化(Deserialize)是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树
 * n <= 100, 0 <= 每个节点的值 <= 150
 * 空间复杂度O(n)，时间复杂度O(n)
 */

public class JZ37 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * Method 1: Using recursion by the rule of preorder to write the tree into a list with some divide signal and
     * signal for null.
     */
    //序列的下标
    public int index = 0;

    //处理序列化的功能函数（递归）
    private void SerializeFunction(TreeNode root, StringBuilder str) {
        //如果节点为空，表示左子节点或右子节点为空，用#表示
        if (root == null) {
            str.append('#');
            return;
        }
        //根节点
        str.append(root.val).append('!');
        //左子树
        SerializeFunction(root.left, str);
        //右子树
        SerializeFunction(root.right, str);
    }

    public String Serialize1(TreeNode root) {
        //处理空树
        if (root == null)
            return "#";
        StringBuilder res = new StringBuilder();
        SerializeFunction(root, res);
        //把str转换成char
        return res.toString();
    }

    //处理反序列化的功能函数（递归）
    private TreeNode DeserializeFunction1(String str) {
        //到达叶节点时，构建完毕，返回继续构建父节点
        //空节点
        if (str.charAt(index) == '#') {
            index++;
            return null;
        }
        //数字转换
        int val = 0;
        //遇到分隔符或者结尾
        while (str.charAt(index) != '!' && index != str.length()) {
            val = val * 10 + ((str.charAt(index)) - '0');
            index++;
        }
        TreeNode root = new TreeNode(val);
        //序列到底了，构建完成
        if (index == str.length())
            return root;
        else
            index++;
        //反序列化与序列化一致，都是前序
        root.left = DeserializeFunction1(str);
        root.right = DeserializeFunction1(str);
        return root;
    }

    public TreeNode Deserialize1(String str) {
        //空序列对应空树
        if (str == "#")
            return null;
        TreeNode res = DeserializeFunction1(str);
        return res;
    }

}
