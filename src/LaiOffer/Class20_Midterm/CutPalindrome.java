package LaiOffer.Class20_Midterm;

/**
 * Question 3: Given a string. a partitioning of the string is a palindrome partitioning if every substring of the
 * partition is a palindrome. For example, "aba b bbabb ababa" is a palindrome partitioning of "ababbbabbababa".
 * Determine the fewest cuts needed for palindrome partitioning of a given string.
 * For example, minimum 3 cuts are needed for "ababbbabbababa". The three cuts are "a babbbab b ababa".
 * If a string is palindrome, then minimum O cuts are needed.
 */
public class CutPalindrome {

    public static void main(String[] args) {
        System.out.println(cutPalindrome("aababaa"));
    }

    private static int cutPalindrome(String input) {
        if (input.length() == 0) {
            return -1;
        }

        int[] dp = new int[input.length() + 1];
        dp[0] = 0;

        for (int i = 1; i <= input.length(); i++) {
            int min = input.length() - 1;
            if (isPalindrome(input, 0, i - 1)) {
                dp[i] = 0;
            } else {
                for (int j = 1; j <= i - 1; j++) {
                    if (isPalindrome(input, j, i - 1)) {
                        min = Math.min(min, dp[j] + 1);
                    }
                }
                dp[i] = min;
            }
        }

        return dp[input.length()];
    }

    private static boolean isPalindrome(String input, int start, int end) {
        while (start <= end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
