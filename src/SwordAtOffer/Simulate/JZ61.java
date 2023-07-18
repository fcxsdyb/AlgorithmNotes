package SwordAtOffer.Simulate;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ61 扑克牌顺子
 * 现在有2副扑克牌，从扑克牌中随机五张扑克牌，我们需要来判断一下是不是顺子
 * 有如下规则：
 * 1.A为1，J为11，Q为12，K为13，A不能视为14
 * 2.大、小王为 0，0可以看作任意牌
 * 3.如果给出的五张牌能组成顺子（即这五张牌是连续的）就输出true，否则就输出false
 * 4.数据保证每组5个数字，每组最多含有4个零，数组的数取值为 [0, 13]
 * 空间复杂度O(1), 时间复杂度O(n log n), 时间复杂度也可以为O(n)
 */

public class JZ61 {

    /**
     * Method 1: Using Hashset to record all the number. If meet 0, then ignore it. If meet same number, return false.
     * Record all other number, if max - min >= 5, then false.
     */
    public boolean IsContinuous1(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        //遍历数组
        for (int number :
                numbers) {
            if (number == 0) {
                continue;
            }
            //包含相同牌则直接返回，否则加入
            if (set.contains(number)) {
                return false;
            } else {
                set.add(number);
            }
            //每次遍历记录最大值，最小值
            max = StrictMath.max(max, number);
            min = StrictMath.min(min, number);
        }
        return max - min < 5;
    }

    /**
     * Method 2: SwordAtOffer.Sort the array and do the same check.
     */
    public boolean IsContinuous2(int[] numbers) {
        int king = 0, max, min;
        //将数组排序
        Arrays.sort(numbers);
        for (int i = 0; i < 4; i++) {
            //记录王牌个数
            if (numbers[i] == 0) king++;
            else if (numbers[i] == numbers[i + 1]) return false;
        }
        max = numbers[4];
        min = numbers[king];// king的个数会占去前置位的数组，nums[king]必然是最小值
        //最大值和最小值进行比较小于5即是顺子
        return numbers[4] - numbers[king] < 5;
    }

}
