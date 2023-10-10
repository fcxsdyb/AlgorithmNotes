package LaiOffer.Class8_HashTable_String_I;

/**
 * String Question 1.2: Remove all leading/trailing and duplicate empty spaces
 * (only leave one empty space if duplicated spaces happen) from the input string.
 * Example: String input = "   abc  ed  ef  " -> output: "abc ed ef"
 * <p>
 * Solution:
 * Step 1: Skip all leading/duplicate empty space.
 * Step 2: Add only one empty space in front of each word. (Except for the 1st word in the sentence)
 */
public class String_RemoveSpaces {

    public static void main(String[] args) {
        char[] array = "  abc  ed  ef  ".toCharArray();
        removeSpaces(array);
    }

    private static void removeSpaces(char[] array) {
        int slow = 0;
        int fast = 0;
        int wordCount = 0;

        while (fast < array.length) {
            if (array[fast] == ' ') {
                fast++;
                continue;
            }

            if (wordCount > 0) {
                array[slow] = ' ';
                slow++;
            }

            while (fast < array.length && array[fast] != ' ') {
                array[slow] = array[fast];
                slow++;
                fast++;
            }
            wordCount++;
        }

        System.out.println(new String(array, 0, slow));
    }

}
