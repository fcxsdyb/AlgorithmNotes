package LaiOffer.Class9_String_II;

import java.util.HashMap;

/**
 * String Advance 4.1: Sliding window in a string (slow + fast indices)
 * Given a string, returns the length of the longest substring without duplicate characters.
 * For example, the longest substrings without repeating characters for "BDEFGADE" are "BDEFGA"
 * whose size is 6 (Follow up: without duplicate k-times characters. e.g. k = 5)
 * <p>
 * Critical Point for review:
 * We must maintain a hash_table that reflects the real-time information about the elements within the sliding window:
 * When we move the R border, we add information to the hash_table.
 * When we move the L border, we delete information from the hash_table.
 */
public class String_SlidingWindow {

    public static void main(String[] args) {
        char[] array = "BDEFGADE".toCharArray();
        findLongest(array);
    }

    private static void findLongest(char[] array) {
        HashMap<Character, Integer> substring = new HashMap<>();

        int s = 0;
        int max = 0;
        int start = 0, end = 0;
        for (int i = 0; i < array.length; i++) {
            substring.put(array[i], substring.getOrDefault(array[i], 0) + 1);

            if (substring.get(array[i]) > 1) {
                while (substring.get(array[i]) > 1) {
                    substring.put(array[s], substring.get(array[s]) - 1);
                    s++;
                }
            } else {
                if (i - s + 1 > max) {
                    max = i - s + 1;
                    start = s;
                    end = i;
                }
            }
        }

        System.out.println(new String(array, start, end - start + 1));
    }

}
