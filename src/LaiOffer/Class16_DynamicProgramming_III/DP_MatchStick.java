package LaiOffer.Class16_DynamicProgramming_III;

/**
 * DP question 3b:
 * Given a bunch of matches. Try to find the largest square.
 * <p>
 * Examples:
 * - - - - - - - -
 * ｜     ｜
 * ｜     ｜
 * - - - - - - -
 * ｜  ｜
 * ｜  ｜
 * - - -
 */
public class DP_MatchStick {

    /**
     * Solution: Using modelling, OOD and DP thinking
     * Each point using two index to judge whether it has
     * p00 _p01 _p02 _ _ _
     * ｜             ｜
     * p10  p11 p12 p13
     * ｜_   _   _    ｜
     * p20  p21
     * ｜    ｜
     * ｜_   _   _
     *
     * class Point {
     *     int right_to_left;  // 1
     *     int bottom_top;     // 1
     * }
     *
     * p00  p01 p02 p03 p04
     * 1    1   1   1   ...
     * 1    0   0   0   ...
     *
     * p10  p11 p12 p13 p14
     * 0    0   0   0   ...
     * 1    0   0   0   ...
     *
     * p20  p21 p22 p23 p24
     * 1    1   x   x   ...
     * 1    1   x   x   ...
     */

}
