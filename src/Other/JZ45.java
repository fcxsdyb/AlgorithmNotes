package Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ45 把数组排成最小的数
 * 输入一个非负整数数组numbers，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * 例如输入数组[3，32，321]，则打印出这三个数字能排成的最小数字为321323
 * 1.输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 2.拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * 0 <= len(numbers) <= 100
 */

public class JZ45 {

    /**
     * Method: Using Comparator to do the personal setting compare rule.
     */
    public String PrintMinNumber(int[] numbers) {
        //空数组的情况
        if (numbers == null || numbers.length == 0)
            return "";
        String[] nums = new String[numbers.length];
        //将数字转成字符
        for (int i = 0; i < numbers.length; i++)
            nums[i] = numbers[i] + "";
        //按照重载排序
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        StringBuilder res = new StringBuilder();
        //字符串叠加
        for (int i = 0; i < nums.length; i++)
            res.append(nums[i]);
        return res.toString();
    }

}
