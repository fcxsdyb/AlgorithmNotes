package LaiOffer.Class2_Recursion_I_BinarySearch;

/**
 * Fibonacci Sequence
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fiboI(10));
        System.out.println(fiboII(10));
    }

    private static int fiboII(int n) {
        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[n];
    }

    /**
     * Recursion
     * F(4)
     * /        \
     * F(3)        F(2)
     * / \         / \
     * F(2)   F(1)  F(1)  F(0)
     * /   \
     * F(1)  F(0)
     * Time Complexity = 1 + 2 + 4 + 8 + 2^(n-1) = O(2^n)
     * Space Complexity = O(n)
     */
    private static int fiboI(int n) {
        //Base Case
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        //Recursion Rule
        return fiboI(n - 1) + fiboI(n - 2);
    }

}
