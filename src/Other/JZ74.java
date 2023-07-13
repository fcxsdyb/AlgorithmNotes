package Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ74 和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是10087-0
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)6
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * 输出所有和为S的连续正数序列
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 0 <= n <= 100
 * 时间复杂度O(n)
 */

public class JZ74 {

    /**
     * Method 1: Enumerate.
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int sum1 = 0;
        //因为序列至少两个数，因此枚举最多到该数字的一半向下取整
        int up = (sum - 1) / 2;
        //枚举左区间
        for (int i = 1; i <= up; i++) {
            //从左区间往后依次连续累加
            for (int j = i; ; j++) {
                sum1 += j;
                //大于目标和则跳出该左区间
                if (sum1 > sum) {
                    sum1 = 0;
                    break;
                    //等于则找到
                } else if (sum1 == sum) {
                    sum1 = 0;
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    //记录线序的数字
                    for (int k = i; k <= j; k++)
                        temp.add(k);
                    res.add(temp);
                    break;
                }
            }
        }
        return res;
    }

    /**
     * Method 2: Sliding Windows.
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //从1到2的区间开始
        for (int l = 1, r = 2; l < r; ) {
            //计算区间内的连续和
            int sum1 = (l + r) * (r - l + 1) / 2;
            //如果区间内和等于目标数
            if (sum1 == sum) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                //记录区间序列
                for (int i = l; i <= r; i++)
                    temp.add(i);
                res.add(temp);
                //左区间向右
                l++;
                //如果区间内的序列和小于目标数，右区间扩展
            } else if (sum1 < sum)
                r++;
                //如果区间内的序列和大于目标数，左区间收缩
            else
                l++;
        }
        return res;
    }

}
