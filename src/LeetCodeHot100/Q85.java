package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406.根据身高重建队列
 */

public class Q85 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] p : people)
            list.add(p[1], p);
        return list.toArray(new int[list.size()][2]);
    }

}
