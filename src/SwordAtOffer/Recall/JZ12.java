package SwordAtOffer.Recall;

import java.lang.*;

/**
 * 剑指Offer
 * JZ12 矩阵中的路径
 * 请设计一个函数，用来判断在一个n乘m的矩阵中是否存在一条包含某长度为len的字符串所有字符的路径
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子
 * 0 <= n, m <= 20, 1 <= len <= 25
 */

public class JZ12 {

    /**
     * Method 1: Using recursion and a finding algorithm to check whether the character equals to the target one. And
     * give a sign for previous route.
     */
    public boolean hasPath(char[][] matrix, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //从[i,j]这个坐标开始查找
                if (dfs(matrix, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] matrix, char[] word, int i, int j, int index) {
        //边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        //如果这个字符不等于matrix[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || matrix[i][j] != word[index])
            return false;
        //如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1)
            return true;
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = matrix[i][j];
        //然后修改当前坐标的值
        matrix[i][j] = '.';
        //走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(matrix, word, i + 1, j, index + 1)
                || dfs(matrix, word, i - 1, j, index + 1)
                || dfs(matrix, word, i, j + 1, index + 1)
                || dfs(matrix, word, i, j - 1, index + 1);
        //递归之后再把当前的坐标复原
        matrix[i][j] = tmp;
        return res;
    }

}
