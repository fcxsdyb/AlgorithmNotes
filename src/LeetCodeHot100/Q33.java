package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.子集
 * 回溯！！！
 */

public class Q33 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        System.out.println("add " + tmp);
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            System.out.println("before " + tmp);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
            System.out.println("after " + tmp);
        }
        System.out.println("return " + tmp);
    }

    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

}
