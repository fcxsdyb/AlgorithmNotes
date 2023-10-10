package Interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XCQ1 {

    static int res = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] array = new int[length];
        boolean[] arrayBoo = new boolean[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            arrayBoo[i] = true;
        }

        dfs(array, arrayBoo, 0, length, new ArrayList<Integer>());
        System.out.println(res);
    }

    private static void dfs(int[] array, boolean[] arrayBoo, int size, int length, List<Integer> temp) {
        if (size == length) {
            int num = temp.get(temp.size() - 1) + temp.get(temp.size() - 2);
            if (check(num)) {
                res++;
            } else {
                return;
            }
        }

        if (temp.size() > 1 && !check(temp.get(temp.size() - 1) + temp.get(temp.size() - 2))) {
            return;
        }

        for (int i = 0; i < length; i++) {
            if (arrayBoo[i]) {
                temp.add(array[i]);
                size++;
                arrayBoo[i] = false;
                dfs(array, arrayBoo, size, length, temp);
                temp.remove(temp.get(temp.size() - 1));
                size--;
                arrayBoo[i] = true;
            }
        }
    }

    private static boolean check(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i != 0) {
                return true;
            }
        }
        return false;
    }
}
