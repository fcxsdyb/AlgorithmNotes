package ClassicalProblem;

public class Sqrt_Binary {

    public static int sqrt(int x) {
        long start = 0, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                end = mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
    
}