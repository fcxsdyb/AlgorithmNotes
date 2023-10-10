package LeetCodeHot100;

import java.util.*;

/**
 * 39.组合总和
 */

public class Q19 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, res, new ArrayList<>());
        return res;
    }

    public void dfs(int[] candidates, int item, int sum, int target, List<List<Integer>> res, List<Integer> count) {
        if (sum == target) {
            res.add(new ArrayList<>(count));
            return;
        }

        for (int i = item; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            count.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates, i, sum, target, res, count);
            count.remove(count.size() - 1);
            sum -= candidates[i];
        }
    }

}
