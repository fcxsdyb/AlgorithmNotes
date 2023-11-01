package LaiOffer.Class9_String_II;

import java.util.Arrays;

/**
 * String Advance 3: String En/Decoding
 * Restriction: in-place
 * Example: "aaaabccaaaaa" -> "a4b1c2a5"
 */
public class String_EncodingDecoding {

    public static void main(String[] args) {
        char[] array = "aaaabccaaaaa".toCharArray();
        encoding(array);
    }

    private static void encoding(char[] array) {
        int countSingle = 0;
        int countLength = 0;
        int slow = 0, fast = 0;

        char temp = array[0];
        while (true) {
            if (fast == array.length) {
                if (countLength != 1) {
                    array[slow++] = temp;
                    array[slow] = (char) ('0' + countLength);
                } else {
                    array[slow] = temp;
                    countSingle++;
                }
                break;
            }

            if (array[fast] != temp) {
                if (countLength != 1) {
                    array[slow++] = temp;
                    array[slow++] = (char) ('0' + countLength);
                } else {
                    array[slow++] = temp;
                    countSingle++;
                }

                temp = array[fast];
                countLength = 1;
            } else {
                countLength++;
            }
            fast++;
        }

        char[] res = new char[slow + 1 + countSingle];
        int index = res.length - 1;
        if (index == res.length - 1 && Character.isLetter(array[slow])) {
            res[index--] = '1';
            res[index] = array[slow];
        }
        while (index >= 0) {
            if (Character.isLetter(array[slow]) && Character.isLetter(array[slow + 1])) {
                res[index--] = '1';
                res[index--] = array[slow--];
            } else {
                res[index--] = array[slow--];
            }
        }

        System.out.println(Arrays.toString(res));
    }

}
