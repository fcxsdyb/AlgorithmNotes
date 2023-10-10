package LaiOffer.Class1_BasicDataStructure_SortAlgorithm;

import java.util.Stack;

/**
 * Using two stacks to sort the number save in the given stack.
 * Assume the given stack doesn't have duplicated element.
 * <p>
 * Time Complexity = O(n^2)
 * Space Complexity = O(n)
 */
public class TwoStackSort {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(14);
        stack.push(2);
        stack.push(23);
        stack.push(8);

        Stack<Integer> result = twoStackSort(stack);
        while (!result.isEmpty()) {
            System.out.print(result.pop() + " ");
        }
    }

    private static Stack<Integer> twoStackSort(Stack<Integer> stack) {
        int size = stack.size();
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> min = new Stack<>();
        int globalMin = Integer.MAX_VALUE;

        while (min.size() < size) {
            while (!stack.isEmpty()) {
                int element = stack.pop();
                if (element < globalMin) {
                    globalMin = element;
                }
                temp.push(element);
            }

            min.push(globalMin);
            while (!temp.isEmpty()) {
                int element = temp.pop();
                if (element != globalMin) {
                    stack.push(element);
                }
            }
            globalMin = Integer.MAX_VALUE;
        }

        return min;
    }

}
