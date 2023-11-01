package LaiOffer.Class12_Recursion_II;

/**
 * Recursion Question 1: a^b
 * 1. 0 as the denominator
 * 2. 1/3 as an integer?? or float
 * 0 ^ 0
 */
public class Recursion_APowerB {

    public static void main(String[] args) {
        int a = 4, b = -3;
        double result = APowerB(a, b);
        System.out.println(result);
    }

    private static double APowerB(int a, int b) {
        if (a == 0 && b <= 0) {
            return -1;
        } else if (b < 0) {
            return (double) 1 / power(a, b);
        } else {
            return (double) power(a, b);
        }
    }

    private static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int half_result = power(a, b / 2);
        if (b % 2 == 0) {
            return half_result * half_result;
        } else {
            return half_result * half_result * a;
        }
    }

}
