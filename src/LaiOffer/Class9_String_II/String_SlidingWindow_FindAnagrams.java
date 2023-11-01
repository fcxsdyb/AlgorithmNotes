package LaiOffer.Class9_String_II;

/**
 * String Advance 4.2: Find all anagrams of a substring s2 in a long string s1
 * String s2 = "aabc"
 * String s1 = "zzzzcdebcaabcyywwww"
 */
public class String_SlidingWindow_FindAnagrams {

    /**
     * Solution: Using sliding window
     * Create a hashmap for s2. Count the key numbers of hashmap at the start point of the s1 which is 3 in this e.g.
     * Start from the s1 head to s2 length, check if s1 first substring has the char of hashmap. Then start move from
     * start to the end. If character exists, then deduct the number in the hashmap. Otherwise, keep going and remember
     * to remove character from the hashmap and add new into it. Once a value of a key equals to 0, the sum of the key
     * numbers should minus one. If the sum equals to 0, we will output the value from the start to end.
     */

}
