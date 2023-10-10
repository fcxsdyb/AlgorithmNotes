package Interview;

import java.util.Scanner;

public class BDQ4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int start = Math.min(a, b);
        int large = Math.max(a, b);
        int res = 0;

        for (int i = start; i <= large; i++) {
            int length = String.valueOf(i).length();
            int temp = i;
            int max = 0;
            while (temp > 0 && length > 0) {
                max = Math.max(max, temp % 10);
                if (max == 9) break;
                temp /= 10;
                length--;
            }
            res += max;
        }

        System.out.println(res);
    }
}
