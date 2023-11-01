package LaiOffer.Class9_String_II;

import java.util.Arrays;

/**
 * String Question 5: Char Replace
 * Example: stu den t -> stu xx t
 */
public class String_CharReplace {

    public static void main(String[] args) {
        String input = "studentdent";
        replace(input, "den", "xx");
        replace(input, "den", "xxxx");
    }

    private static void replace(String input, String origin, String replace) {
        char[] array = input.toCharArray();
        if (array.length < origin.length() || array.length < replace.length()) {
            System.out.println(Arrays.toString(array));
        }

        if (origin.length() >= replace.length()) {
            replaceLess(input, array, origin, replace);
        } else {
            replaceLarger(input, origin, replace);
        }
    }

    private static void replaceLarger(String source, String target, String replacement) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < source.length()) {
            // Check if the substring at the current index matches the target
            if (i <= source.length() - target.length() && source.startsWith(target, i)) {
                result.append(replacement);
                i += target.length();
            } else {
                result.append(source.charAt(i));
                i++;
            }
        }

        System.out.println(result);
    }

    private static void replaceLess(String input, char[] array, String origin, String replace) {
        int slow = 0;
        int fast = 0;

        while (fast < input.length()) {
            if (input.charAt(fast) == origin.charAt(0)) {
                if (input.startsWith(origin, fast)) {
                    for (int i = 0; i < replace.length(); i++) {
                        array[slow++] = replace.charAt(i);
                    }
                    fast += origin.length();
                } else {
                    array[slow++] = array[fast++];
                }
            } else {
                array[slow++] = array[fast++];
            }
        }

        System.out.println(new String(array, 0, slow));
    }

}
