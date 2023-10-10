package Interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JDQ1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] input = new int[length];
        int[] res = new int[length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            input[i] = in.nextInt();
        }

        for (int i = length - 1; i >= 0; i--) {
            int temp = input[i] % (i + 1) == 0 ? i + 1 : i + 1 - (input[i] % (i + 1));
            while (map.containsKey(temp)) {
                temp += i + 1;
            }
            res[i] = temp;
            map.put(temp, 1);
        }

        for (Integer result : res) {
            System.out.print(result + " ");
        }
    }

}
