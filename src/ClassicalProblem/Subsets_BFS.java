package ClassicalProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_BFS {

    private static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> queue = new ArrayList<>();
        int index = 0;

        Arrays.sort(nums);
        queue.add(new ArrayList<>());
        while (index < queue.size()) {
            List<Integer> subset = queue.get(index++);
            for (int num : nums) {
                if (subset.size() != 0 && subset.get(subset.size() - 1) >= num) {
                    continue;
                }
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(num);
                queue.add(newSubset);
            }
        }

        return queue;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        for (List<Integer> list : subsets(nums)) {
            System.out.println(list);
        }
    }

}
