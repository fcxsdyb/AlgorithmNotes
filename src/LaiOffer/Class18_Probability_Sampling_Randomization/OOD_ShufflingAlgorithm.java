package LaiOffer.Class18_Probability_Sampling_Randomization;

/**
 * Question 1: shuffling algorithm (OOD)
 * Spades, Hearts, Diamonds, Clubs
 */
public class OOD_ShufflingAlgorithm {

    /**
     * index || 0  1  2  3  4  5  6 ...  50  51
     *         c0 c1 c2                     c51
     * Iteration 1: call random (0 -- 51) -> random_number1 = 5, call swap(5, 51)
     *              P(every card can show up in position 51) = 1/52
     * Iteration 2: call random (0 -- 50) -> random_number2 = 8, call swap(8, 50)
     *              P(every card can show up in position 50) = (1 - 1/52) * 1/51 = 1/52
     */

}
