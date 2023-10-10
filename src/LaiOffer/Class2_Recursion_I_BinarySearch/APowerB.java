package LaiOffer.Class2_Recursion_I_BinarySearch;

/**
 * How to calculate a^b
 * where a is an integer and bis also an integer, we do not care about the corner case where a = 0 or b < 0 for now
 * <p>
 * Time Complexity = O(log b)
 * Space Complexity = O(log b)
 */
public class APowerB {

    public static void main(String[] args) {
        System.out.println(a_power_b(3, 4));
    }

    private static long a_power_b(int a, int b) {
        //Base Case
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        }

        //Recursion Rule
        long half = a_power_b(a, b / 2);
        if (b % 2 == 0) {
            return half * half;
        } else {
            return half * half * a;
        }
    }

}
