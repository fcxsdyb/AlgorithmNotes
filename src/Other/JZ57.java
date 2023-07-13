package Other;

import java.util.*;
import java.lang.*;

/**
 * 剑指Offer
 * JZ57 和为S的两个数字
 * 输入一个升序数组 array 和一个数字S，在数组中查找两个数，使得他们的和正好是S
 * 如果有多对数字的和等于S，返回任意一组即可，如果无法找出这样的数字，返回一个空数组即可
 * 0 <= len(array) <= 10^5, 1 <= array[i] <= 10^6
 */

public class JZ57 {

    /**
     * Method 1: Hashtable. Record key and its index. Deduct it and check whether the result has stored in the
     * hashtable.
     */
    public ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //创建哈希表,两元组分别表示值、下标
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        //在哈希表中查找target-numbers[i]
        for (int i = 0; i < array.length; i++) {
            int temp = sum - array[i];
            //若是没找到，将此信息计入哈希表
            if (!mp.containsKey(temp)) {
                mp.put(array[i], i);
            } else {
                //取出数字添加
                res.add(temp);
                res.add(array[i]);
                break;
            }
        }
        return res;
    }

    /**
     * Method 2: Two pointers. One pointer direct to minimum and one direct to maximum. Then moving two pointers to the
     * center by checking the sum of both numbers.
     */
    public ArrayList<Integer> FindNumbersWithSum2(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //左右双指针
        int left = 0, right = array.length - 1;
        //对撞双指针
        while(left < right){
            //相加等于sum，找到目标
            if(array[left] + array[right] == sum){
                res.add(array[left]);
                res.add(array[right]);
                break;
                //和太大，缩小右边
            }else if(array[left] + array[right] > sum)
                right--;
                //和太小，扩大左边
            else
                left++;
        }
        return res;
    }

}
