package LaiOffer.Class2_Recursion_I_BinarySearch;

/**
 * Apply binary search in checking whether an element is in an unknown size dictionary or not
 * <p>
 * Variant 2.0 application:
 * Given a sorted dictionary with unknown size, how to determine whether a word is in this dictionary or not.
 * <p>
 * Example: dictionary[x] = {1 3 5 7 9 ... 1000 ... 1000000 ...}, target = 9999
 * Assumption if a[index］== NULL then we know the size of dictionary is < index
 * <p>
 * Jump by 2 times VS Jump by 10 times
 * To jump out: log2(n) VS log10(n)
 * To jump in: log2(2n) VS log2(10n)
 * Compare:
 * 10 times - 2 times
 * = log10(n) + log2(10n) - log2(n) - log2(2n)
 * = log10(n) - log2(n) + log2(10n / 2n)
 * = log10(n) - log2(n) + log2(5) (close to 2.5)
 * log10(n) is much smaller than log2(n)
 * Conclusion: jump 10 steps is faster than 2 steps
 */
public class BinarySearch_UnknownSizeDictionary {

    /**
     * Solution:
     * Start from a[0], a[1].
     * Jump 2 times or 10 times once to check whether the data is smaller than target number or not.
     * If the number is smaller than target number, keep checking a[2], a[4], a[8] ... or a[10], a[100], a[1000] ...
     * Once the number is larger than target number, using binary search to check whether target number
     * is between a[2^(n-1)] and a[2^n] or between a[10^(n-1)] and a[10^n]
     */

}
