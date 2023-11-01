package LaiOffer.Class13_DynamicProgramming_I;

import java.util.HashSet;

/**
 * DP Thinking Question: Given a word, can it be composed by concatenating words from a given dictionary?
 * Example:
 * Dictionary: 1.bob 2.cat 3.rob
 * Word1: bcoabt -> False
 * Word2: bobcatrob -> True
 */
public class DP_DictionaryProblem {

    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("bob");
        dict.add("cat");
        dict.add("rob");

        System.out.println(dictRetrieve(dict, "bcoabt"));
        System.out.println(dictRetrieve(dict, "bobcat"));
        System.out.println(dictRetrieve(dict, "bobca"));
        System.out.println(dictRetrieve(dict, "robob"));
    }

    /**
     * Time Complexity = O(n ^ 2 * n == n ^ 3 (Substring cost n))
     */
    private static boolean dictRetrieve(HashSet<String> dict, String word) {
        boolean[] res = new boolean[word.length() + 1];
        res[0] = true;

        for (int i = 1; i <= word.length(); i++) {
            if (dict.contains(word.substring(0, i))) {
                res[i] = true;
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (res[j] && dict.contains(word.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[word.length()];
    }

}
