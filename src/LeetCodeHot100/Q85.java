package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406.根据身高重建队列
 */

public class Q85 {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        //add element with index value
        for (int[] p : people)
            list.add(p[1], p);
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        int[][] result = reconstructQueue(people);
    }

}
