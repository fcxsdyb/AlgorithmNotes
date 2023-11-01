package LaiOffer.Class18_Probability_Sampling_Randomization;

/**
 * Question 2: How to do sampling for an unlimited data flow and when reading the n-th element we are required to
 * return one random number among all numbers read so far, such that the probability of returning any element read
 * so far is 1/n. We only use O(1) space to solve this problem.
 */
public class Sampling_ReturnNumFromUnlimitedData {

    /**
     * Solution:
     * t=0 call random[0-0] = random_num1, if random_num1 == 0 -> solution = input[0].
     * P(input[0] will be returned as the solution) = 100%
     *
     * t=1 call random[0-1] = random_num2, if random_num2 == 0 -> solution = input[1]
     * P(input[0] will be returned as the solution) = 1- 50% = 50%
     * P(input[1] will be returned as the solution) = 50%
     *
     * t=2 call random[0-2] = random_num3, if random_num3 == 0 -> solution = input[2]
     * P(input[0] will be returned as the solution) = 1/2 * (1 - 1/3) = 1/3
     * P(input[1] will be returned as the solution) = 1/2 * (1 - 1/3) = 1/3
     * P(input[2] will be returned as the solution) = 1/3
     *
     * t=3...
     */

}
