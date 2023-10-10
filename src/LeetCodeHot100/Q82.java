package LeetCodeHot100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347.前K个高频元素
 */

public class Q82 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //统计出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(key) > map.get(queue.peek())) {
                queue.poll();
                queue.add(key);
            }
        }

        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }

}
