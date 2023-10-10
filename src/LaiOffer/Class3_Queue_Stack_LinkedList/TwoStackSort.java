package LaiOffer.Class3_Queue_Stack_LinkedList;

import java.util.Stack;

/**
 * Question 3: How to sort numbers with three (or two) stacks? What if there are duplicate element?
 */
public class TwoStackSort {

    public static void main(String[] args) {
        Stack<Integer> input = new Stack<>();
        input.push(3);
        input.push(2);
        input.push(1);
        input.push(6);
        input.push(5);
        input.push(1);
        input.push(2);
        Stack<Integer> res = stackSort(input);
        while (!res.isEmpty()) {
            System.out.print(res.pop() + " ");
        }
    }

    //Keep popping element >= globalMin back to input and save the globalMin in the min stack
    private static Stack<Integer> stackSort(Stack<Integer> input) {
        Stack<Integer> min = new Stack<>();
        int globalMin = Integer.MAX_VALUE;
        int count = 0;

        while (!input.isEmpty()) {
            while (!input.isEmpty()) {
                if (input.peek() < globalMin) {
                    globalMin = input.peek();
                    count = 1;
                } else if (input.peek() == globalMin) {
                    count++;
                }
                min.push(input.pop());
            }

            while (!min.isEmpty() && min.peek() >= globalMin) {
                if (min.peek() != globalMin) {
                    input.push(min.pop());
                } else {
                    min.pop();
                }
            }

            for (int i = 0; i < count; i++) {
                min.push(globalMin);
            }
            globalMin = Integer.MAX_VALUE;
            count = 0;
        }

        return min;
    }

}
