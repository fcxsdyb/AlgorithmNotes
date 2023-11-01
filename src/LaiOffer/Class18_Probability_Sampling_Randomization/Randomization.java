package LaiOffer.Class18_Probability_Sampling_Randomization;

/**
 * Question 3
 */
public class Randomization {

    /**
     * Question 3a: How to design a random number generator Random(7), with Random(5).
     * Random(7): [0-6]
     * Random(5): [0-4]
     *
     * 1. Reverse Direction: Random(7) -> Random(5)
     * 2. Real Problem: Random(5) -> Random(7)
     * Random(5) -> Random(25) -> Random(7)
     * r1 = 1
     * 0 1 2 3 4
     * 5 6 0 1 2
     * 3 4 5 6 0
     * 1 2 3 4 5
     * 6 . . . .0-
     * M[r1][r2] -> evenly distributed among all numbers in this matrix
     * call Random(5) for the 1st time = random_num1[0--4] = row number
     * call Random(5) for the 2nd time = random_num2[0--4] = column number
     * generated_number = r1 * 5 + r2
     *
     * return the number as the output of Random(7) if (generated_number = r1 * 5 + r2) fall into [0--20],
     * so the final result = generated_number % 7.
     *
     * Question 3b: How to design a random number generator Random(1,000,000), with Random(5).
     * Solution:
     * 1og_5（1,000,000）
     * binary representation random(2) = [0, 1]
     *
     * We only need to call random(2) 20 times to solve this problem!!
     *
     * X XXXX XXXXX XXXXX XXX X         x => decimal representation of the random number
     * r19                   r1        r0
     * 2^10 = 1024 1K
     * 2^20 = 1M
     * 2^30 = 1G
     * 2^40 = 1T
     * 2^50 = 1P
     * 2^60 = 1E
     */

}
