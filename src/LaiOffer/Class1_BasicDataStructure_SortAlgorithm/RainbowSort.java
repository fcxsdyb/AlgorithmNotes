package LaiOffer.Class1_BasicDataStructure_SortAlgorithm;

import java.util.Arrays;

/**
 * aaaaaaabbbbbbbb  cbcabcabcabcbcacbca  ccccccc --> aaaaaaa bbbbbbbbb ccccccc
 * Assume all the elements are 'a' 'b' or 'c'. Need to sort string between b to c.
 */
public class RainbowSort {
    public static void main(String[] args) {
        String chars = "aaaaabbbbbcbcabcabcabcbcacbcaccccc";
        System.out.println(chars.length());
        char[] charArray = chars.toCharArray();
        rainbowSort(charArray, 5, 10, 29);
        System.out.println(Arrays.toString(charArray));
    }

    private static void rainbowSort(char[] charArray, int a, int b, int c) {
        while (b <= c) {
            if (charArray[b] == 'a') {
                swap(charArray, b, a);
                a++;
                b++;
            } else if (charArray[b] == 'b') {
                b++;
            } else {
                swap(charArray, b, c);
                c--;
            }
        }
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
