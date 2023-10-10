package ClassicalProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_DFS {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        dfs(new ArrayList<>(), nums, 0, result);
        return result;
    }

    private static void dfs(List<Integer> subset, int[] nums, int start, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(subset, nums, i + 1, result);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        for (List<Integer> list : subsets(nums)) {
            System.out.println(list);
        }

    }

}
