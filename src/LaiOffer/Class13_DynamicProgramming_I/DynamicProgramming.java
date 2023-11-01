package LaiOffer.Class13_DynamicProgramming_I;

public class DynamicProgramming {

    /**
     * DP的核心思想类似于我们高中学习的数学归纳法：
     * 1. 把一个大问题（size == n）的解决方案用比他小的问题（问题们）来解决，也就是思考从问题size = n-1 增加到 size = n 的时候，
     * 如何用小问题的solution构建大问题的solution。
     *
     * 2. 与recursion的关系：
     *      2.1. Recursion 从大到小来解决问题，不记录任何sub-solution只要考虑
     *          2.1.1. base case
     *          2.1.2. recursive rule
     *      2.2. DP 从小到大来解决问题，记录sub-solution
     *          2.2.1. 由size(<n)的 sub-solution(s) -> size(n)的solution
     *          2.2.2. base case
     *          2.2.3. induction rule
     *
     * DP的解题常用方法：
     * 1. 一维的original data (such as a rope, a word, a piece of wood), 求MAX or MIN (cut, merge, etc..)
     *      1.1. if the weight of each smallest element in the original data is identical/similar
     *          1.1.1.  e.g. identical: 1 meter of rope
     *          1.1.2.  e.g. similar: a letter, a number
     *      Then this kind of problem is usually simple:
     *      Linear scan and look back to the previous element(s)
     *      For example:
     *      Longest Ascending Subarray (when at i, look back at i-1)
     *      Longest Ascending Subsequence (when at i, look back at 1...i-1)
     *      Cut rope
     *      Cut palindrome
     *
     *      1.2 if the weight are not the same
     *          1.2.1. e.g.DP1 课后题:沙子归并
     *          1.2.2. e.g.强化练习题:切木头
     *      从中心开花,［index = 0.1.2.3. N-1］, for each M[i, j], we usually need to try out all possible k that (i<k<j),
     *      M［i, j] = max(M[i, k］+/-/* M［k, j]) (for all possible k)
     */

}
