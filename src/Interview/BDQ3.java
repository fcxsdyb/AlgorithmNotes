package Interview;

import java.util.Scanner;

public class BDQ3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        long res = 0L;
        int range = (int) Math.pow(10, length);
        for (int i = 0; i < range; i++) {
            int odd = 0;
            int even = 0;
            int test = i;
            int numLength = String.valueOf(test).length();

            while (test > 0 && numLength > 0) {
                if (numLength % 2 == 0) {
                    even += test % 10;
                } else {
                    odd += test % 10;
                }
                test = test / 10;
                numLength--;
            }

            res += (long) odd * even;
        }

        System.out.println(res % (int) (Math.pow(10, 9) + 7));
    }
}
