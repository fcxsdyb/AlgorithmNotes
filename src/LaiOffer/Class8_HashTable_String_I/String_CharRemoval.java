package LaiOffer.Class8_HashTable_String_I;

/**
 * String Question 1.1: Remove a/some particular chars from a string.
 * Example: String input = "student", remove "u and n" -> output: "stdet"
 */
public class String_CharRemoval {

    public static void main(String[] args) {
        char[] array = "studentu".toCharArray();
        removeChar(array, new char[]{'t'});
    }

    private static void removeChar(char[] array, char[] delete) {
        int index = 0;
        boolean check;

        for (int i = 0; i < array.length; i++) {
            check = false;
            for (char c : delete) {
                if (array[i] == c) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                array[index] = array[i];
                index++;
            }
        }

        System.out.println(new String(array, 0, index));
    }

}
